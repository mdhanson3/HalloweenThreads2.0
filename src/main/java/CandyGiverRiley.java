import java.util.Queue;

import org.apache.log4j.Logger;

/**
 * Created by student on 11/2/16.
 */
public class CandyGiverRiley extends Thread {
    public CandyGiverRiley(Queue<String> halloweeners){
        this.halloweeners = halloweeners;
    }

    private Queue<String> halloweeners;
    private final Logger logger = Logger.getLogger(this.getClass());
    private String currentHalloweener;
    private int failSafeCounter;

    public void run()  {
        failSafeCounter = 0;



        while(true) {
            if(halloweeners.size() > 0) {
                logger.info("Riley's Queue: " + halloweeners.size());
                giveCandy();
            }
            failSafeCounter++;
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void giveCandy() {
        currentHalloweener = halloweeners.remove();
        logger.info("Gave candy to: " + currentHalloweener);
        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
