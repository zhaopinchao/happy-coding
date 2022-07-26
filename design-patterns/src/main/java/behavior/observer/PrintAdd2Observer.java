package behavior.observer;

/**
 * @author zhaopc
 * @date 2021/3/5 21:02
 */
public class PrintAdd2Observer implements Observer {

    @Override
    public void doBusiness(int i) {
        System.out.println("i + 2 = " + (i + 2));
    }
}
