package com.zorac.model

import org.junit.After
import org.junit.Before
import org.junit.Test

class BoardTest {

    private lateinit var board: Board

    private val testValues = arrayOf(
        arrayOf("1", "2", "3"),
        arrayOf("4", "5", "6"),
        arrayOf("7", "8", "9")
    )

    @Before
    fun setUpBoard() {
        board = Board(3)
    }

    @Test
    fun testBoardAllCellsAreUninitialized() {
        assert(board.getCells().all { !it.isInitialized })
    }

    @Test
    fun testNewBoardIsInvalid() {
        assert(!board.isValid())
    }

    @Test
    fun testBoardWithDistinctValuesIsValid() {
        board = Board(testValues)
        assert(board.isValid())
    }

    @Test
    fun testBoardWithNonDistinctValuesIsInvalid() {
        board = Board(testValues)
        board.setCell(1, 1, "1")
        assert(!board.isValid())
    }

    @After
    fun cleanBoard() {
        board = Board(3)
    }
}