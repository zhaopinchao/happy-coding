package behavior.template.callback;

/**
 * @author zhaopc
 * @date 2021/5/29 22:33
 */
public class AClass implements ICallBack{

    @Override
    public void callBackMethod() {
        System.out.println("hello i am AClass");
    }

    public void callBClass() {
        BClass bClass = new BClass();
        bClass.process(this);
    }

    public static void main(String[] args) {
        AClass aClass = new AClass();
        aClass.callBClass();
    }
}
