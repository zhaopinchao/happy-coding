package behavior.observer.eventbus;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 注册观察者类
 *
 * @author zhaopc
 * @date 2021/3/10 22:37
 */
public class ObserverRegistry {

    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Object obj) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = findObserverActions(obj);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
            if (registeredEventActions == null) {
                registry.put(eventType, new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(eventType);
            }
            registeredEventActions.addAll(eventActions);
        }
    }

    private Map<Class<?>, Collection<ObserverAction>> findObserverActions(Object obj) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>(16);
        Class<?> clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 1) {
                    throw new RuntimeException("被Subscribe注解的观察者方法，只能有一个参数");
                }
                Class<?> key = parameterTypes[0];
                ObserverAction action = new ObserverAction(obj, method);
                if (!observerActions.containsKey(key)) {
                    observerActions.put(key, new ArrayList<>());
                }
                observerActions.get(key).add(action);
            }
        }
        return observerActions;
    }

    public void unregister(Object obj) {
        Class<?> aClass = obj.getClass();
        for (Method declaredMethod : aClass.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(Subscribe.class)) {
                if (declaredMethod.getParameterTypes().length == 1) {
                    Class<?> key = declaredMethod.getParameterTypes()[0];
                    if (registry.containsKey(key)) {
                        ObserverAction action = new ObserverAction(obj, declaredMethod);
                        CopyOnWriteArraySet<ObserverAction> observerActions = registry.get(key);
                        observerActions.removeIf(observerAction -> observerAction.equals(action));
                    }
                }
            }
        }
    }

    public List<ObserverAction> listMatchedObserverActions(Object param) {
        List<ObserverAction> observerActions = new ArrayList<>();
        Class<?> aClass = param.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> key = entry.getKey();
            CopyOnWriteArraySet<ObserverAction> value = entry.getValue();
            if (aClass.isAssignableFrom(key)) {
                observerActions.addAll(value);
            }
        }
        return observerActions;
    }

}
