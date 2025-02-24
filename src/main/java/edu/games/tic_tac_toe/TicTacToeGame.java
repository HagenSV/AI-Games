package edu.games.tic_tac_toe;

import edu.games.util.Timer;

public class TicTacToeGame {
    private final AIStats ai1;
    private final AIStats ai2;

    public TicTacToeGame(AIStats ai1, AIStats ai2){
        this.ai1 = ai1;
        this.ai2 = ai2;
        play();
    }

    private void play(){
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeAI player1;
        TicTacToeAI player2;
        Timer t = new Timer();

        try {
            long p1Start;
            long p2Start;

            t.start();
            player1 = (TicTacToeAI) ai1.ai.getConstructors()[0].newInstance('X');
            p1Start = t.stop();

            t.start();
            player2 = (TicTacToeAI) ai2.ai.getConstructors()[0].newInstance('O');
            p2Start = t.stop();

            ai1.addStartupTime(p1Start);
            ai2.addStartupTime(p2Start);

        } catch (Exception e){
            System.out.println("Failed to initialize AI");
            return;
        }

        boolean p1turn = true;
        char winner = ' ';
        boolean forfeit = false;
        while (!board.isFull() && winner == ' ' && !forfeit){
            TicTacToeBoard copy = new TicTacToeBoard(board);

            t.start();
            if (p1turn) {
                for (int i = 1; i <= 10; i++) {
                    int move = player1.play(copy);
                    if (board.setVal(move,'X')){
                        ai1.addMoveTime(t.stop());
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
                        ai2.addMoveTime(t.stop());
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
            ai1.addWin();
            if (forfeit){
                ai2.addForfeit();
            } else {
                ai2.addLoss();
            }
        }
        else if (winner == 'O'){
            ai2.addWin();
            if (forfeit){
                ai2.addForfeit();
            } else {
                ai2.addLoss();
            }
        } else {
            ai1.addTie();
            ai2.addTie();
        }
    }
}
