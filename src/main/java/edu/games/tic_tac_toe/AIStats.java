package edu.games.tic_tac_toe;

public class AIStats {
    public final TicTacToeAI ai;

    public static final int WIN_POINTS = 4;
    public static final int TIE_POINTS = 2;
    public static final int LOSS_POINTS = 0;
    public static final int FORFEIT_POINTS = -2;

    private long initTime;
    private int played;
    private int moves;
    private long moveTime;
    private int wins;
    private int ties;
    private int losses;
    private int forfeit;

    public AIStats(TicTacToeAI ai){
        this.ai = ai;
    }

    protected void addStartupTime(long nanos) {
        initTime += nanos;
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

    public long getAverageInit(){
        return initTime /played;
    }

    public long getAverageMove(){
        return moveTime/moves;
    }

    public int getScore(){
        return getWins() * WIN_POINTS +
                getTies() * TIE_POINTS +
                getLosses() * LOSS_POINTS +
                getForfeit() * FORFEIT_POINTS;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ai.getName()).append(" Stats\n");
        sb.append("Played: ").append(getPlayed()).append("\n");
        sb.append("Wins: ").append(getWins()).append("\n");
        sb.append("Ties: ").append(getTies()).append("\n");
        sb.append("Losses: ").append(getLosses()).append("\n");
        sb.append("Forfeit: ").append(getForfeit()).append("\n");
        sb.append("Average Init Time: ").append(getAverageInit()/1000).append("ms \n");
        sb.append("Average Move Time: ").append(getAverageMove()/1000).append("ms \n");
        sb.append("Score: ").append(getScore()).append("\n");
        return sb.toString();
    }
}
