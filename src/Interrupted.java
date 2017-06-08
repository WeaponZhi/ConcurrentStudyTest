/**
 * Interrupted 测试中断标志位
 * author:张冠之
 * time: 2017/6/8 10:49
 * e-mail: guanzhi.zhang@sojex.cn
 */

class Interrupted {
    public static void main(String[] args) {
        //sleepThread 不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        //busyThread 不停的运行
        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        //休眠 5 秒，让 sleepThread 和 busyThread 充分运行
        SleepUtils.second(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is "+sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is "+busyThread.isInterrupted());
        //防止 sleepThread 和 busyThread 立即退出
        SleepUtils.second(2);
    }

    /**
     * 不停睡眠的线程
     */
    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }

    /**
     * 一直运行的线程
     */
    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println("1");
            }
        }
    }
}
