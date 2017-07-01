import java.util.concurrent.locks.Lock;

/**
 * TwinsLockTest 验证 TwinsLock 是否能按照预期工作
 * 运行可以看到同一时刻只有两个线程能够取到锁
 * <p>
 * author:张冠之<br>
 * time: 2017/07/01 14:14 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class TwinsLockTest {
    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        //启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        //每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
            
        }
    }
}
