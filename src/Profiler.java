/**
 * Profiler ThreadLocal的使用
 * 这个类可以被复用在方法调用耗时统计的功能上。好处是这两个方法的调用不用在一个方法或者类中。
 * author:张冠之
 * time: 2017/6/9 16:02
 * e-mail: guanzhi.zhang@sojex.cn
 */

class Profiler {
    //第一次 get() 方法调用时会初始化（如果 set 方法没有调用），每个线程会调用一次。
    private static final ThreadLocal<Long> TIME_THREADLOCAL = ThreadLocal.withInitial(() -> System.currentTimeMillis());

    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) {
        Profiler.begin();
        SleepUtils.second(1);
        System.out.println("Cost: "+ Profiler.end() + "　mills");
    }
}
