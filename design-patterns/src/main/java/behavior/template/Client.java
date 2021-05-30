package behavior.template;

/**
 * @author zhaopc
 * @date 2021/5/30 20:19
 */
public class Client extends TestTemplate {

    @Override
    public void doProcess() {
        System.out.println("hi, i am doing");
    }

    @Override
    public void setUp() {
        System.out.println("初始化数据成功");
    }

    @Override
    public void clean() {
        System.out.println("清理数据成功");
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
