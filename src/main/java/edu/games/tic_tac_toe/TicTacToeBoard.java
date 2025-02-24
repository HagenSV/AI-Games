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

    /**
     * Checks for a winner
     * @return the char representing the winner or ' ' if no winner
     */
    public char checkWin(){
        for (int i = 0; i < 3; i++){
            //Check rows for winner
            if (winner(getVal(i,0),getVal(i,1),getVal(i,2))){
                return getVal(i,1);
            }

            //Check columns for winner
            if (winner(getVal(0,i),getVal(1,i),getVal(2,i))){
                return getVal(0,i);
            }
        }

        if (winner(getVal(0,0),getVal(1,1),getVal(2,2))){
            return getVal(1,1);
        }
        if (winner(getVal(0,2),getVal(1,1),getVal(2,0))){
            return getVal(1,1);
        }

        return ' ';
    }

    private boolean winner(char val1, char val2, char val3){
        return val1 != ' ' && val1 == val2 && val2 == val3;
    }
}
