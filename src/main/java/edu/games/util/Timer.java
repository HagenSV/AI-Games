package edu.games.util;

/**
 * Class dedicated to measuring time differences
 */
public class Timer {

    private static Timer instance;
    private long startTime;

    private Timer(){
        startTime = 0;
    }

    public static Timer getInstance(){
        if (instance == null){
            instance = new Timer();
        }
        return instance;
    }

    /**
     * Starts the timer at the current time;
     */
    public void start(){
        startTime = System.nanoTime();
    }

    /**
     * Stops the timer and returns the current time
     * @return the current time in nanoseconds
     */
    public long stop(){
        long endTime = System.nanoTime();
        return endTime -startTime;
    }
}
