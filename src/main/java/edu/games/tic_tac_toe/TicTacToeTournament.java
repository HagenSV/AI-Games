package edu.games.tic_tac_toe;

public class TicTacToeTournament {

    public static void main(String[] args) {
        AIStats[] stats = TicTacToeTournament.play(new RandomAI());

        for (AIStats stat : stats) {
            System.out.println(stat);
        }
    }

    public static AIStats[] play(TicTacToeAI... ais){
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
