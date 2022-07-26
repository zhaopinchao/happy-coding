package behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaopc
 * @date 2021/3/5 21:03
 */
public class ObserverTest {

    public static void main(String[] args) {
        List<Observer> observers = new ArrayList<>();
        observers.add(new PrintObserver());
        observers.add(new PrintAdd1Observer());
        observers.add(new PrintAdd2Observer());

        // a+b，理解为处理当前
        int a = 1;
        int b = 2;
        int i = a + b;

        // 处理其他业务
        for (Observer observer : observers) {
            observer.doBusiness(i);
        }
    }
}
