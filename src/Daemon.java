/**
 * Daemon 测试 Daemon 线程
 * author:张冠之
 * time: 2017/6/8 10:17
 * e-mail: guanzhi.zhang@sojex.cn
 */

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * 运行 Daemon 程序，可以看到在终端或者命令提示符上没有任何输出。即 Daemon 线程中的 finally 块
     * 在 JVM 退出时不一定执行。
     * 所以在构建 Daemon 线程时，不能依靠 finally 块中的内容来确保执行关闭或清理资源的逻辑。
     */
    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try {
              SleepUtils.second(5);
            }finally {
                System.out.println("DaemonThread finally run,");
            }
        }
    }
}
