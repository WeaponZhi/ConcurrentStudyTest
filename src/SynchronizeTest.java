import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/6/1.
 */

class SynchronizeTest {
    List<Integer> mList = new ArrayList<>();

    public void addList() {
        System.out.println("start");
        new Thread(() -> {
            synchronized (mList) {
                for (int i = 0; i < 10; i++) {
                    mList.add(i);
                    System.out.println("add " + i);
                }
            }
        }).start();
    }

    public void addListNoLock()  {
        new Thread(() -> {
            synchronized (mList) {
                for (int i = 0; i < 10; i++) {
                    mList.add(i);
                    System.out.println("add no lock " + i);
                }
            }
        }).start();

    }

    public static void main(String[] args) {
        SynchronizeTest synchronizeTest = new SynchronizeTest();
        synchronizeTest.addList();
        synchronizeTest.addListNoLock();
    }
}
