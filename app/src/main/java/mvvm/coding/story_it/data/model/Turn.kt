package mvvm.coding.story_it.data.model

import mvvm.coding.story_it.data.db.entity.Player


data class Turn(val currentPlayer: Player, val currentWord: Word, val prevWords:List<Word>) {
}