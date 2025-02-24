package edu.games.tic_tac_toe;

import edu.games.Board;

public class TicTacToeBoard extends Board {

    /**
     * Creates a blank tic-tac-toe board
     */
    public TicTacToeBoard() {
        super(3, 3, ' ');
    }

    /**
     * Creates a deep copy
     * @param b the board object to copy
     */
    public TicTacToeBoard(TicTacToeBoard b) {
        super(b);
    }

    @Override
    public boolean setVal(int cell, char val) {
        if (getVal(cell) != ' '){
            return false;
        }
        return super.setVal(cell, val);
    }

    @Override
    public boolean setVal(int r, int c, char val) {
        if (getVal(r,c) != ' '){
            return false;
        }
        return super.setVal(r, c, val);
    }

    /**
     * Checks if the game board is full
     * @return true if there are no open spaces
     */
    public boolean isFull(){
        for (int i = 0; i < CELLS; i++){
            if (getVal(i) == ' '){
                return false;
            }
        }
        return true;
    }
}
