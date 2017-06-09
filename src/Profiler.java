/**
 * Profiler ThreadLocal的使用
 * author:张冠之
 * time: 2017/6/9 16:02
 * e-mail: guanzhi.zhang@sojex.cn
 */

class Profiler {
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
        System.out.println("Cost: "+ Profiler.end() + "mills");
    }
}
