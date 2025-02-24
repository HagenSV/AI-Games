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

    public class AIStats {
        public final Class<? extends TicTacToeAI> ai;
        private int wins;
        private int ties;
        private int losses;
        private int forfeit;

        public AIStats(Class<? extends TicTacToeAI> ai){
            this.ai = ai;
        }

        protected void addWin(){
            wins++;
        }

        protected void addTie(){
            ties++;
        }

        protected void addLoss(){
            losses++;
        }

        protected void addForfet(){
            forfeit++;
        }

        public int getWins() {
            return wins;
        }

        public int getTies() {
            return ties;
        }

        public int getLosses() {
            return losses;
        }

        public int getForfeit() {
            return forfeit;
        }
    }
}
