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
     * Determines if a cell is open for play
     * @param cell the id of the cell to check
     * @return true if the cell can be played on
     */
    public boolean isOpen(int cell){
        return getVal(cell) == ' ';
    }

    /**
     * Determines if a cell is open for play
     * @param r the row of the cell to check
     * @param c the column of the cell to check
     * @return true if the cell can be played on
     */
    public boolean isOpen(int r, int c){
        return getVal(r,c) == ' ';
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
