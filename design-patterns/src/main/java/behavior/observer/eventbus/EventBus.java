package behavior.observer.eventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author zhaopc
 * @date 2021/3/5 21:12
 */
public class EventBus {

    private Executor executor;
    private final ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object obj) {
        registry.register(obj);
    }

    public void post(Object param) {
        List<ObserverAction> observerActions = registry.listMatchedObserverActions(param);
        executor.execute(() -> {
            for (ObserverAction observerAction : observerActions) {
                observerAction.execute(param);
            }
        });
    }
}
