package behavior.template;

/**
 * 测试模板
 *
 * @author zhaopc
 * @date 2021/5/30 20:15
 */
public abstract class TestTemplate {

    /**
     * 模板方法
     */
    public final void run() {
        // 初始化
        setUp();
        //执行逻辑
        doProcess();
        // 清理
        clean();
    }

    /**
     * 执行逻辑
     */
    public abstract void doProcess();

    /**
     * 初始化数据
     */
    public abstract void setUp();

    /**
     * 清理
     */
    public abstract void clean();
}
