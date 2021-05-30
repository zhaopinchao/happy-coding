package behavior.template.callback;

/**
 * @author zhaopc
 * @date 2021/5/29 22:34
 */
public class BClass {

    public void process(ICallBack callBack) {
        System.out.println("hello, i am BClass, how are u");
        callBack.callBackMethod();
    }
}
