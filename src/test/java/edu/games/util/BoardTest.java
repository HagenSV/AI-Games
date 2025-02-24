package edu.games.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void blankBoard(){
        Board b = new Board(3,3);
        for (int i = 0; i < b.CELLS; i++){
            assertEquals(0,b.getVal(i));
        }
    }

    @Test
    void filledBoard(){
        Board b = new Board(3,3,'a');
        for (int i = 0; i < b.CELLS; i++){
            assertEquals('a',b.getVal(i));
        }
    }

    @Test
    void deepCopy() {
        Board b1 = new Board(10,10, 'x');
        Board b2 = new Board(b1);

        b1.setVal(2,3,'y');

        assertEquals('x',b2.getVal(2,3));
    }

    @Test
    void setValCoordinate() {
        Board b = new Board(10,10);
        b.setVal(1,1,'a');
        assertEquals('a',b.getVal(1,1));
        assertEquals('a',b.getVal(11));
    }

    @Test
    void setValById() {
        Board b = new Board(10,10);
        b.setVal(50,'c');
        assertEquals('c',b.getVal(5,0));
        assertEquals('c',b.getVal(50));
    }
}