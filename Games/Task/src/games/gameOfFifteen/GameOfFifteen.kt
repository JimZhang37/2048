package games.gameOfFifteen

import board.Cell
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
            private val board = createGameBoard<Int?>(4)

            override fun initialize() {

                for ((index, value) in initializer.initialPermutation.withIndex()) {
                    lateinit var cell :Cell
                    when(index){
                        in 0..3 ->cell = Cell(1,(index+1))
                        in 4..7 ->cell = Cell(2,index-3)
                        in 8..11 -> cell = Cell(3, index-7)
                        in 12..15 -> cell = Cell(4, index-11)
                    }
                    //println(cell)
                    board.set(cell, value)
                    //println(board.get(cell))
                }

                board.set(Cell(4,4),null)
//                println(board)
            }

            override fun canMove() = board.any { it == null }

            override fun hasWon(): Boolean {
                for (index in 0..14) {
                    lateinit var cell :Cell
                    when(index){
                        in 0..3 ->cell = Cell(1,(index+1))
                        in 4..7 ->cell = Cell(2,index-3)
                        in 8..11 -> cell = Cell(3, index-7)
                        in 12..15 -> cell = Cell(4, index-11)
                    }
                    println(cell)

                    println(board.get(cell))
                    if (board.get(cell) != index+1) return false
                }
                return true
            }

            override fun processMove(direction: Direction) {
                val cellNull = board.find { it == null }
                val i = (cellNull?.i)?:0
                val j = (cellNull?.j)?:0
                println("i is: $i. j is: $j.")
                when (direction) {
                    Direction.DOWN -> {
                        println("down")
                        if(i!! >1){
                            val cell = Cell((i-1),j)
                            val a = board.get(cell)
                            board.set(cellNull!!, a)
                            board.set(cell,null)
                        }
                    }
                    Direction.UP -> {
                        println("up")
                        if(i!! <4){
                            val cell = Cell((i+1),j)
                            val a = board.get(cell)
                            board.set(cellNull!!, a)
                            board.set(cell,null)
                        }
                    }
                    Direction.LEFT -> {
                        println("left")
                        if(j!! <4){
                            val cell = Cell(i,(j+1))
                            val a = board.get(cell)
                            board.set(cellNull!!, a)
                            board.set(cell,null)
                        }
                    }
                    Direction.RIGHT -> {
                        println("right")
                        if(j!! >1){
                            val cell = Cell(i,(j-1))
                            val a = board.get(cell)
                            board.set(cellNull!!, a)
                            board.set(cell,null)
                        }
                    }
                }
            }

            override fun get(i: Int, j: Int): Int? {
                val cell = Cell(i, j)
                return board.get(cell)
            }
        }


/*
 * Add a new value produced by 'initializer' to a specified cell in a board.
 */

