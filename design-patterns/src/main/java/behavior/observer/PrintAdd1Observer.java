package behavior.observer;

/**
 * @author zhaopc
 * @date 2021/3/5 20:58
 */
public class PrintAdd1Observer implements Observer {

    @Override
    public void doBusiness(int i) {
        System.out.println("i + 1 = " + (i + 1));
    }
}
