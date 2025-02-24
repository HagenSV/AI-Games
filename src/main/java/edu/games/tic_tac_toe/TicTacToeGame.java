package edu.games.tic_tac_toe;

public class TicTacToeGame {
    TicTacToeAI player1;
    TicTacToeAI player2;
    TicTacToeBoard board;

    public static void main(String[] args) {
        new TicTacToeGame(RandomAI.class,RandomAI.class);
    }

    public TicTacToeGame(Class<? extends TicTacToeAI> ai1, Class<? extends TicTacToeAI> ai2){

        board = new TicTacToeBoard();
        try {
            player1 = (TicTacToeAI) ai1.getConstructors()[0].newInstance('X');
            player2 = (TicTacToeAI) ai2.getConstructors()[0].newInstance('O');
        } catch (Exception e){
            System.out.println("Failed to initialize AI");
        }

        boolean p1turn = true;
        while (!board.isFull()){
            TicTacToeBoard copy = new TicTacToeBoard(board);

            if (p1turn) {
                player1.play(copy);
            } else {
                player2.play(copy);
            }

            p1turn = !p1turn;
        }
    }
}
