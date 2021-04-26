package structure.proxy;

/**
 * @author zhaopc
 * @date 2021/4/21 22:02
 */
public class UserProxyControllerImpl implements IUserController {

    private IUserController userController;

    public UserProxyControllerImpl(IUserController userController) {
        this.userController = userController;
    }

    @Override
    public String login(String username, String password) {
        long start = System.currentTimeMillis();
        String loginResult = userController.login(username, password);
        long end = System.currentTimeMillis();
        // 打印耗时
        System.out.println("登陆耗时：" + (end - start));
        return loginResult;
    }
}
