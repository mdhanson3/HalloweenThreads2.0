import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * Created by student on 11/2/16.
 */
public class CandyGiverRileyTest {
    public Queue<String> halloweeners;
    @Before
    public void setupQueue() {
        halloweeners = new LinkedList();
        halloweeners.add("Tom");
        halloweeners.add("Steve");
        halloweeners.add("Bill");
        halloweeners.add("Jane");
    }
    @Test
    public void testRileyGivesCandy() throws Exception {
        CandyGiverRiley rileyThread = new CandyGiverRiley(halloweeners);
        rileyThread.start();
        try{
            sleep(2000);
        } catch(Exception e) {

        }
        assertEquals("Halloweeners queue is not empty.", halloweeners.size(), 0);

    }

    @Test
    public void testHalloweenQueueInserterThread() {
        HalloweenQueueInserterThread weenerInserter = new HalloweenQueueInserterThread(halloweeners);
        weenerInserter.start();
        try{
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFullApplication() {
        CandyGiverRiley rileyThread = new CandyGiverRiley(halloweeners);
        HalloweenQueueInserterThread weenerInserter = new HalloweenQueueInserterThread(halloweeners);

        rileyThread.start();
        weenerInserter.start();

        try{
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //rileyThread.interrupt();
        //weenerInserter.interrupt();

    }

}