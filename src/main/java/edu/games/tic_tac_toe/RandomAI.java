package edu.games.tic_tac_toe;

/**
 * Example TicTacToeAI, good for testing other AIs
 */
public class RandomAI extends TicTacToeAI {

    public RandomAI(char assignedChar) {
        super(assignedChar);
    }

    @Override
    public String getName() {
        return "RandomAI";
    }

    /**
     * Requests the bot to make a move
     *
     * @param board the board to play on
     * @return the id of the cell to play
     */
    @Override
    public int play(TicTacToeBoard board) {
        int move = random();
        //Keep attempting random moves until one is valid
        while (!board.isOpen(move)){
            move = random();
        }
        return move;
    }

    private int random(){
        return (int)(Math.random()*9);
    }
}
