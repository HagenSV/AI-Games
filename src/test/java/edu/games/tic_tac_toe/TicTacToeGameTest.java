package edu.games.tic_tac_toe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {
    public static class ForfeitAI extends TicTacToeAI {
        public ForfeitAI(char assignedChar) {
            super(assignedChar);
        }

        @Override
        public String getName() {
            return "ForfeitAI";
        }

        @Override
        public int play(TicTacToeBoard board) {
            return 0;
        }
    }

    @Test
    void testForfeit(){
        AIStats ai1 = new AIStats(ForfeitAI.class);
        AIStats ai2 = new AIStats(ForfeitAI.class);

        TicTacToeGame game = new TicTacToeGame(ai1,ai2);

        System.out.println(ai1);

        assertEquals(0,ai1.getForfeit());
        assertEquals(1,ai2.getForfeit());
    }
}