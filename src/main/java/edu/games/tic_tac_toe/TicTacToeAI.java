package edu.games.tic_tac_toe;

public abstract class TicTacToeAI {

    protected final char ASSIGNED_CHAR;

    public TicTacToeAI(char assignedChar){
        ASSIGNED_CHAR = assignedChar;
    }

    /**
     * Requests the bot to make a move
     * @param board the board to play on
     * @return the id of the cell to play
     */
    public abstract int play(TicTacToeBoard board);
}
