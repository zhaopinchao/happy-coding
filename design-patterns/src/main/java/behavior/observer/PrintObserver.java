package behavior.observer;

/**
 * @author zhaopc
 * @date 2021/3/5 21:00
 */
public class PrintObserver implements Observer {

    @Override
    public void doBusiness(int i) {
        System.out.println("i = " + i);
    }
}
