import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admin on 2017/5/16.
 */

class TimerTest {
    public static void main(String[] args) throws InterruptedException {
//        RunnableTest runnableTest = new RunnableTest();
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.scheduleAtFixedRate(runnableTest, 0, 1, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(runnableTest,0,2,TimeUnit.SECONDS);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("sss");
            }
        };
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("ddd");
            }
        };
        timer.schedule(timerTask,0,1000);
        Thread.sleep(5000);
        timer.cancel();
        timer.purge();
        timer.schedule(timerTask,0,1000);
    }
    static class RunnableTest implements Runnable{

        @Override
        public void run() {
            System.out.println("timer123");
        }
    }
}
