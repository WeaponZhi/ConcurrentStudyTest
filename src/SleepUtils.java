import java.util.concurrent.TimeUnit;

/**
 * SleepUtils 睡眠静态方法
 * author:张冠之
 * time: 2017/6/8 10:22
 * e-mail: guanzhi.zhang@sojex.cn
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
