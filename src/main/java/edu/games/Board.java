package edu.games;

public class Board {
    public final int ROWS;
    public final int COLS;
    public final int CELLS;
    private final char[][] board;

    public Board(int rows, int cols){
        ROWS = rows;
        COLS = cols;
        CELLS = rows*cols;
        board = new char[rows][cols];
    }

    public Board(int rows, int cols, char defaultVal) {
        this(rows, cols);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = defaultVal;
            }
        }
    }

    public char getVal(int r, int c){
        return board[r][c];
    }

    public char getVal(int cell){
        return board
    }

    public boolean setVal(int r, int c, char val){
        board[r][c] = val;
        return true;
    }

    public boolean setVal(int cell, char val){
        board[cell/ROWS][cell%ROWS] = val;
        return true;
    }
}
