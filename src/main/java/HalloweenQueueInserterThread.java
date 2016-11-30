import org.apache.log4j.Logger;

import java.util.Queue;


/**
 * Created by student on 11/2/16.
 */
public class HalloweenQueueInserterThread extends Thread {
    public HalloweenQueueInserterThread(Queue<String> halloweeners) {
        this.halloweeners = halloweeners;

    }

    private Queue<String> halloweeners;
    private final Logger logger = Logger.getLogger(this.getClass());
    private String currentHalloweener;
    private int failSafeCount;
    private long randomSleeptime;

    public void run() {


        failSafeCount = 0;
        while(failSafeCount < 50 || true) {
            randomSleeptime = (long) ((Math.random() * 900) + 100);
            try{
                sleep(randomSleeptime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(halloweeners.size() < 10) {
                halloweeners.add("Kid #" + Integer.toString(failSafeCount));
                logger.info("Halloween Inserter Queue Size: " + halloweeners.size());

            }
            failSafeCount++;
        }
    }
}
