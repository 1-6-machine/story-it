package mvvm.coding.story_it.data.db.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import mvvm.coding.story_it.data.db.entity.Player
import mvvm.coding.story_it.data.db.entity.Score
import mvvm.coding.story_it.data.model.Game

interface GameRepository {
    @WorkerThread
    fun getPlayers() : List<Player>

    fun getPlayerOf(id: Long) : LiveData<Player>
    @WorkerThread
    fun getScores() :LiveData<List<Score>>

    fun getScoreOf(id: Long) : LiveData<Score>
    @WorkerThread
    fun addPlayer(player: Player)
    @WorkerThread
    fun addScore(score: Score)

    fun setGame(game: Game)
    fun getGame():LiveData<Game>
}