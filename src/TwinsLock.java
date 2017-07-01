import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * TwinsLock 自定义同步工具--TwinsLock
 * 在同一时刻，只允许至多两个线程进行访问，超过两个线程的访问将被阻塞
 * <p>
 * author:张冠之<br>
 * time: 2017/07/01 13:55 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class TwinsLock implements Lock {
    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count < 0) {
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(count);
        }

        /**
         * 同步器的共享式同步状态的获取
         *
         * @param reduceCount
         * @return
         */
        @Override
        protected int tryAcquireShared(int reduceCount) {
            for (; ; ) {
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        /**
         * 同步器的共享式同步状态的释放
         *
         * @param returnCount
         * @return
         */
        @Override
        protected boolean tryReleaseShared(int returnCount) {
            for (; ; ) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }

    /**
     * 同一时刻只能有两个线程同时获取到锁
     */
    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
