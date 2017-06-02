import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 * ScheduledTimerExecutor 定时线程池代理类
 * 单线程池模型，强制要求一个 Timer 中只有一个线程任务，如果需要
 * author:张冠之
 * time: 2017/5/17 16:38
 * e-mail: guanzhi.zhang@sojex.cn
 */

class ScheduledTimerExecutor{
    private ScheduledExecutorService mScheduledExecutorService;
    private Future mFuture;
    /**
     * 初始化线程池
     */
    public ScheduledTimerExecutor(){
        //强制要求线程数为 1
        mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }


}
