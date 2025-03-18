package edu.games.tic_tac_toe;

public abstract class TicTacToeAI {

    public abstract String getName();

    /**
     * Requests the AI to make a move
     * @param assigned the character the AI is playing as
     * @param board the board to play on
     * @return the id of the cell to play
     */
    public abstract int play(char assigned, TicTacToeBoard board);
}
