package behavior.observer.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 观察者执行动作类
 *
 * @author zhaopc
 * @date 2021/3/10 22:32
 */
public class ObserverAction {

    private final Object target;
    private final Method method;

    public ObserverAction(Object target, Method method) {
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    /**
     * 执行
     *
     * @param param method方法执行的参数
     */
    public void execute(Object param) {
        try {
            method.invoke(target, param);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ObserverAction that = (ObserverAction) o;
        return Objects.equals(target, that.target) && Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(target, method);
    }
}
