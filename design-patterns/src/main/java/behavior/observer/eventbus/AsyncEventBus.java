package behavior.observer.eventbus;

import java.util.concurrent.Executor;

/**
 * @author zhaopc
 * @date 2021/3/5 21:16
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
