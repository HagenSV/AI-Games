package edu.games.tic_tac_toe;

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

    protected void addForfeit(){
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
