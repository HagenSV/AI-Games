package edu.games.tic_tac_toe;

public class TicTacToeTournament {

    @SafeVarargs
    public static AIStats[] play(Class<? extends TicTacToeAI>... ais){
        int COUNT = ais.length;
        AIStats[] stats = new AIStats[COUNT];

        for (int i = 0; i < COUNT; i++){
            stats[i] = new AIStats(ais[i]);
        }


        for (int i = 0; i < COUNT; i++){
            for (int j = 0; j < COUNT; j++){
                new TicTacToeGame(stats[i],stats[j]);
            }
        }

        return stats;
    }
}
