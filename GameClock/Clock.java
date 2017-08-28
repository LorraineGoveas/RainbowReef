package GameClock;

import java.util.Observable;

import static java.lang.Thread.sleep;

public class Clock extends Observable implements Runnable {
    private static double elapsedTime;
    private static double start;

    private final int SLEEPDURATION = 10;

    public void GameClock() {
        start = System.currentTimeMillis();
    }

    public void tick() {
        updateClockTime();
        setChanged();
        this.notifyObservers();
    }

    private void updateClockTime() {
        elapsedTime = System.currentTimeMillis() - start;
    }

    @Override
    public void run() {
        while ( true ) {
            try {
                sleep( SLEEPDURATION );
                this.tick();
            } catch ( InterruptedException e ) {
            }
        }
    }
}
