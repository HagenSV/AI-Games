package edu.games.util;

public class Board {
    public final int ROWS;
    public final int COLS;
    public final int CELLS;
    private final char[][] board;

    /**
     * Creates a board
     * @param rows number of rows
     * @param cols number of columns
     */
    public Board(int rows, int cols){
        ROWS = rows;
        COLS = cols;
        CELLS = rows*cols;
        board = new char[ROWS][COLS];
    }

    /**
     * Creates a board with a chosen default value
     * @param rows number of rows
     * @param cols number of columns
     * @param defaultVal default value of all cells in the board
     */
    public Board(int rows, int cols, char defaultVal) {
        this(rows, cols);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c] = defaultVal;
            }
        }
    }

    /**
     * Creates a deep copy
     * @param b the board object to copy
     */
    public Board(Board b){
        ROWS = b.ROWS;
        COLS = b.COLS;
        CELLS = b.CELLS;
        board = new char[ROWS][COLS];
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                board[r][c] = b.getVal(r,c);
            }
        }
    }

    /**
     * Gets the value of a cell
     * @param r the row of the cell
     * @param c the column of the cell
     * @return value stored in the cell
     */
    public char getVal(int r, int c){
        return board[r][c];
    }

    /**
     * Gets the value of a cell
     * @param cell the cell number, cells are numbered as row*COLUMNS + column
     * @return the value stored in the cell
     */
    public char getVal(int cell){
        return board[cell/ROWS][cell%ROWS];
    }

    /**
     * Sets the value of a cell
     * @param r the row of the cell
     * @param c the column of the cell
     * @param val the new value
     * @return true if successful
     */
    public boolean setVal(int r, int c, char val){
        board[r][c] = val;
        return true;
    }

    /**
     * Sets the value of a cell
     * @param cell the cell id (formatted as row*COLUMNS + column)
     * @param val the new value
     * @return true if successful
     */
    public boolean setVal(int cell, char val){
        board[cell/ROWS][cell%ROWS] = val;
        return true;
    }
}
