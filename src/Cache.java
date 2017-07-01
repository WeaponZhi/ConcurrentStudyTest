import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Cache 通过该缓存示例说明读写锁的使用方式
 * <p>
 * author:张冠之<br>
 * time: 2017/07/01 15:41 <br>
 * e-mail: zhangguanzhi@csii.com.cn <br>
 * </p>
 */

public class Cache {
    static Map<String,Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();
    //获取一个 key 对应的 value
    public static final Object get(String key){
        r.lock();
        try{
            return map.get(key);
        }finally {
            r.unlock();
        }
    }
    //设置 key 对应的 value，并返回旧的 value
    public static final Object put(String key ,Object value){
        w.lock();
        try {
            return map.put(key,value);
        }finally {
            w.unlock();
        }
    }
    //清空所有的内容
    public static final void clear(){
        w.lock();
        try{
            map.clear();
        }finally {
            w.unlock();
        }
    }
}
