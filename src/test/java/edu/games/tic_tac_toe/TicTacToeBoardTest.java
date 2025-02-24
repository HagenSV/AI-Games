package edu.games.tic_tac_toe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {

    @Test
    void testConstructor(){
        TicTacToeBoard b = new TicTacToeBoard();

        assertEquals(3,b.ROWS);
        assertEquals(3,b.COLS);
        assertEquals(9,b.CELLS);

        for (int i = 0; i < b.CELLS; i++){
            assertEquals(' ',b.getVal(i));
        }
    }

    @Test
    void testEmpty(){
        TicTacToeBoard b = new TicTacToeBoard();

        assertFalse(b.isFull());
        b.setVal(0,'X');
        assertFalse(b.isFull());
    }

    @Test
    void testFull(){
        TicTacToeBoard b = new TicTacToeBoard();
        for (int i = 0; i < b.CELLS; i++){
            b.setVal(i,'X');
        }
        assertTrue(b.isFull());
    }

    @Test
    void testOpen(){
        TicTacToeBoard b = new TicTacToeBoard();

        assertTrue(b.isOpen(3));
        b.setVal(3,'X');
        assertFalse(b.isOpen(3));

    }

    @Test
    void testInvalid(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(-1,'X');
    }

    @Test
    void testInvalid2(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(9,'X');
    }

    @Test
    void checkWinEmpty(){
        TicTacToeBoard b = new TicTacToeBoard();
        assertEquals(' ',b.checkWin());
    }

    @Test
    void checkWinRow1(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(0,0,'X');
        b.setVal(0,1,'X');
        b.setVal(0,2,'X');
        assertEquals('X',b.checkWin());
    }

    @Test
    void checkWinRow2(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(1,0,'X');
        b.setVal(1,1,'X');
        b.setVal(1,2,'X');
        assertEquals('X',b.checkWin());
    }

    @Test
    void checkWinRow3(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(2,0,'X');
        b.setVal(2,1,'X');
        b.setVal(2,2,'X');
        assertEquals('X',b.checkWin());
    }

    @Test
    void checkWinCol1(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(0,0,'X');
        b.setVal(1,0,'X');
        b.setVal(2,0,'X');
        assertEquals('X',b.checkWin());
    }

    @Test
    void checkWinCol2(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(0,1,'X');
        b.setVal(1,1,'X');
        b.setVal(2,1,'X');
        assertEquals('X',b.checkWin());
    }

    @Test
    void checkWinCol3(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(0,2,'X');
        b.setVal(1,2,'X');
        b.setVal(2,2,'X');
        assertEquals('X',b.checkWin());
    }

    @Test
    void checkWinDiagonal1(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(0,0,'X');
        b.setVal(1,1,'X');
        b.setVal(2,2,'X');
        assertEquals('X',b.checkWin());
    }

    @Test
    void checkWinDiagonal2(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(0,2,'X');
        b.setVal(1,1,'X');
        b.setVal(2,0,'X');
        assertEquals('X',b.checkWin());
    }

    @Test
    void checkWinDiagonal1Mixed(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(0,0,'X');
        b.setVal(1,1,'O');
        b.setVal(2,2,'X');
        assertEquals(' ',b.checkWin());
    }

    @Test
    void checkWinDiagonal2Mixed(){
        TicTacToeBoard b = new TicTacToeBoard();
        b.setVal(0,2,'X');
        b.setVal(1,1,'X');
        b.setVal(2,0,'O');
        assertEquals(' ',b.checkWin());
    }
}