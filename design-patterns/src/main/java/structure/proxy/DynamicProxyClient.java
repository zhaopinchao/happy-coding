package structure.proxy;

/**
 * @author zhaopc
 * @date 2021/4/21 22:30
 */
public class DynamicProxyClient {

    // Spring AOP 底层的实现原理就是基于动态代理

    public static void main(String[] args) {
        UserControllerImpl userController = new UserControllerImpl();
        MetricsDynamicProxy proxy = new MetricsDynamicProxy();
        IUserController controller = (IUserController) proxy.createProxy(userController);
        controller.login("hello", "password");
    }
}
