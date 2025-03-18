package edu.games.tic_tac_toe;

import edu.games.util.Timer;

public class TicTacToeGame {
    private final AIStats stats1;
    private final AIStats stats2;

    public TicTacToeGame(AIStats stats1, AIStats stats2){
        this.stats1 = stats1;
        this.stats2 = stats2;
        play();
    }

    private void play(){
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeAI ai1 = stats1.ai;
        TicTacToeAI ai2 = stats2.ai;
        Timer t = new Timer();

        boolean p1turn = true;
        char winner = ' ';
        boolean forfeit = false;
        while (!board.isFull() && winner == ' ' && !forfeit){
            TicTacToeBoard copy = new TicTacToeBoard(board);

            t.start();
            if (p1turn) {
                for (int i = 1; i <= 10; i++) {
                    int move = ai1.play('X',copy);
                    if (board.setVal(move,'X')){
                        stats1.addMoveTime(t.stop());
                        break;
                    }
                    if (i == 10){
                        forfeit = true;
                        winner = 'O';
                    }
                }
            } else {
                for (int i = 1; i <= 10; i++) {
                    int move = ai2.play('O',copy);
                    if (board.setVal(move,'O')){
                        stats2.addMoveTime(t.stop());
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
            stats1.addWin();
            if (forfeit){
                stats2.addForfeit();
            } else {
                stats2.addLoss();
            }
        }
        else if (winner == 'O'){
            stats2.addWin();
            if (forfeit){
                stats1.addForfeit();
            } else {
                stats1.addLoss();
            }
        } else {
            stats1.addTie();
            stats2.addTie();
        }
    }
}
