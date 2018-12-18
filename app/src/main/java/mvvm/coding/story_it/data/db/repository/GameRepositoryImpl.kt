package mvvm.coding.story_it.data.db.repository

import android.util.Log
import androidx.annotation.WorkerThread

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import mvvm.coding.story_it.data.db.PlayerDao
import mvvm.coding.story_it.data.db.ScoreDao
import mvvm.coding.story_it.data.db.entity.Player
import mvvm.coding.story_it.data.db.entity.Score
import mvvm.coding.story_it.data.model.Game
import mvvm.coding.story_it.data.model.Preferences
import mvvm.coding.story_it.data.model.Round
import java.lang.Exception




class GameRepositoryImpl(
    private val playerDao: PlayerDao,
    private val scoreDao: ScoreDao)
    : GameRepository {

    /*
    * Every of those getters sets the value of mutable property from the _game.value.*
    * And then returns LiveData<*> to make it Observable for ViewModels.
    * @TODO FEATURE
    * Store CurrentGame in Database
    * */

    private var _game : MutableLiveData<Game> = MutableLiveData()
    private var _preferences : MutableLiveData<Preferences> = MutableLiveData()
    private var _rounds: MutableLiveData<List<Round>> = MutableLiveData()

    private var _players: MutableLiveData<List<Player>> = MutableLiveData()

    /* @TODO Think about implementation of this, (When the * is current??)
    // @TODO Need to add currentProperty in Parent class of every Obj from (Player -> Turn, Turn -> Round, Round -> Game) */

    //private var _currentTurn : MutableLiveData<Turn> = MutableLiveData()
    private var _currentPlayer: MutableLiveData<Player> = MutableLiveData()
    private var _currentRound: MutableLiveData<Round> = MutableLiveData()

    //region Database Getters Methods
    @WorkerThread
    override fun getPlayers(): List<Player> {
           return playerDao.getPlayers()
    }

    override fun getPlayerOf(id: Long): LiveData<Player> {
        val mutableLiveData = MutableLiveData<Player>()
        val player: Player?
        try {
            player = playerDao.getPlayers().single { player -> player.id == id  }
            mutableLiveData.value = player
        }catch (ex: Exception){
            Log.e("REPOSITORY", ex.localizedMessage)
        }
        return mutableLiveData
    }
    @WorkerThread
    override fun getScores(): LiveData<List<Score>> = scoreDao.getScores()

    override fun getScoreOf(id: Long): LiveData<Score> {
        val mutableLiveData = MutableLiveData<Score>()
        val score: Score?
        try {
            score = scoreDao.getScores().value?.single { score -> score.playerId == id }
            mutableLiveData.value = score
        }catch (ex: Exception){
            Log.e("REPOSITORY", ex.localizedMessage)
        }
        return mutableLiveData
    }
    //endregion

    //region Database Insert Methods
    @WorkerThread
    override fun addPlayer(player: Player) {
        playerDao.addPlayer(player)
    }
    @WorkerThread
    override fun addScore(score: Score) {
        scoreDao.addScore(score)
    }
    //endregion

    //region Getters for MutableProperties stored in this repository only
    override fun getGamePreferences(): LiveData<Preferences> {
        _preferences.value = _game.value?.preferences
        return _preferences
    }

    override fun getGameRounds(): LiveData<List<Round>> {
        _rounds.value = _game.value?.rounds
        return _rounds
    }

    override fun getCurrentGameRound(): LiveData<Round> {
        return _currentRound
    }

    override fun getGamePlayers(): LiveData<List<Player>> {
        _players.value = _preferences.value?.players
        return _players
    }

    override fun getGameCurrentPlayer(): LiveData<Player> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun getGame(): LiveData<Game> = _game
    //endregion


}
