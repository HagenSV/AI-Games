package edu.games.tic_tac_toe;

public class AIStats {
    public final Class<? extends TicTacToeAI> ai;
    private long startupTime;
    private int played;
    private int moves;
    private long moveTime;
    private int wins;
    private int ties;
    private int losses;
    private int forfeit;

    public AIStats(Class<? extends TicTacToeAI> ai){
        this.ai = ai;
    }

    protected void addStartupTime(long nanos) {
        startupTime += nanos;
        played++;
    }

    protected void addMoveTime(long nanos){
        moveTime += nanos;
        moves++;
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

    protected void addForfeit(){
        forfeit++;
    }

    public int getPlayed() {
        return played;
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

    public long getAverageStartUp(){
        return startupTime/played;
    }

    public long getAverageMove(){
        return moveTime/moves;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AI Stats\n");
        sb.append("Played: ").append(played).append("\n");
        sb.append("Wins: ").append(wins).append("\n");
        sb.append("Ties: ").append(ties).append("\n");
        sb.append("Losses: ").append(losses).append("\n");
        sb.append("Forfeit: ").append(forfeit).append("\n");

        return sb.toString();
    }
}
