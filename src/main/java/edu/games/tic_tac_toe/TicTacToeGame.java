package edu.games.tic_tac_toe;

public class TicTacToeGame {
    private final Class<? extends TicTacToeAI> ai1;
    private final Class<? extends TicTacToeAI> ai2;

    public static void main(String[] args) {
        new TicTacToeGame(RandomAI.class,RandomAI.class);
    }

    public TicTacToeGame(Class<? extends TicTacToeAI> ai1, Class<? extends TicTacToeAI> ai2){
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    public Class<? extends TicTacToeAI> play(){
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeAI player1;
        TicTacToeAI player2;
        try {
            player1 = (TicTacToeAI) ai1.getConstructors()[0].newInstance('X');
            player2 = (TicTacToeAI) ai2.getConstructors()[0].newInstance('O');
        } catch (Exception e){
            System.out.println("Failed to initialize AI");
            return null;
        }

        boolean p1turn = true;
        char winner = ' ';
        boolean forfeit = false;
        while (!board.isFull() && winner == ' ' && !forfeit){
            TicTacToeBoard copy = new TicTacToeBoard(board);

            if (p1turn) {
                for (int i = 1; i <= 10; i++) {
                    int move = player1.play(copy);
                    if (board.setVal(move,'X')){
                        break;
                    }
                    if (i == 10){
                        forfeit = true;
                        winner = 'O';
                    }
                }
            } else {
                for (int i = 1; i <= 10; i++) {
                    int move = player2.play(copy);
                    if (board.setVal(move,'O')){
                        break;
                    }
                    if (i == 10){
                        forfeit = true;
                        winner = 'X';
                    }
                }
            }

            if (!forfeit) {
                winner = board.checkWin();
                p1turn = !p1turn;
            }
        }

        if (winner == 'X'){
            return ai1;
        }
        else if (winner == 'O'){
            return ai2;
        } else {
            return null;
        }
    }
}
