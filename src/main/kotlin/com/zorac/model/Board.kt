package com.zorac.model

class Board(private val rows: Int, private val columns: Int) {
    private val board: Array<Array<Cell>> = Array(rows) { Array(columns) { Cell("") } }

    constructor(size: Int) : this(size, size)

    constructor(values: Array<Array<String>>): this(values.size, values[0].size) {
        for (row in 0 until rows) {
            for (column in 0 until columns) {
                board[row][column] =
                    Cell(
                        value = values[row][column],
                        isInitialized = true,
                    )
            }
        }
    }


    fun getCells(): Array<Cell> {
        return board.flatten().toTypedArray()
    }

    fun setCell(row: Int, column: Int, value: String) {
        board[row][column] = Cell(value)
    }

    fun isValid(): Boolean {
        return allCellsAreInitialized() && allValuesAreUnique()
    }
    private fun allCellsAreInitialized(): Boolean {
        return board.flatten().all { it.isInitialized }
    }

    private fun allValuesAreUnique(): Boolean {
        val values = board.flatten().map { it.value }
        return values.distinct().size == values.size
    }
}