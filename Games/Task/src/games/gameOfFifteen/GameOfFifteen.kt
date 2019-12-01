package games.gameOfFifteen

import board.Direction
import board.GameBoard
import board.createGameBoard
import games.game.Game

/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game =
        object : Game {
            override fun initialize() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun canMove(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun hasWon(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun processMove(direction: Direction) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun get(i: Int, j: Int): Int? {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
