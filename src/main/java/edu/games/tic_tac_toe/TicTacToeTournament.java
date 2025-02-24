package edu.games.tic_tac_toe;

public class TicTacToeTournament {

    @SafeVarargs
    public TicTacToeTournament(Class<? extends TicTacToeAI>... ais){
        int COUNT = ais.length;

        int[] wins = new int[COUNT];
        int[] ties = new int[COUNT];
        int[] losses = new int[COUNT];
        int[] forfeit = new int[COUNT];

        for (int i = 0; i < COUNT; i++){
            for (int j = 0; j < COUNT; j++){
                TicTacToeGame game = new TicTacToeGame(ais[i],ais[j]);
                TicTacToeGame.GameResults results = game.play();

                if (ais[i].equals(results.winner)){
                    wins[i] += 1;
                    if (results.opponentForfeit){
                        forfeit[j] += 1;
                    } else {
                         losses[i] += 1;
                    }
                } else if (ais[j].equals(results.winner)){
                    wins[j] += 1;
                    if (results.opponentForfeit){
                        forfeit[i] += 1;
                    } else {
                        losses[i] += 1;
                    }
                } else {
                    ties[i] += 1;
                    ties[j] += 1;
                }
            }
        }
    }
}
