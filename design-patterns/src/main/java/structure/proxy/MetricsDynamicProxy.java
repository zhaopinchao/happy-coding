package structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author zhaopc
 * @date 2021/4/21 22:07
 */
public class MetricsDynamicProxy {

    public Object createProxy(Object proxyObject) {
        Class<?>[] interfaces = proxyObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxyObject);
        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), interfaces, handler);
    }

    private static class DynamicProxyHandler implements InvocationHandler {

        private final Object proxyObject;

        public DynamicProxyHandler(Object proxyObject) {
            this.proxyObject = proxyObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long start = System.currentTimeMillis();
            Object result = method.invoke(proxyObject, args);
            long end = System.currentTimeMillis();
            String apiName = proxyObject.getClass().getName() + "#" + method.getName();
            System.out.println(apiName + "耗时：" + (end - start));
            return result;
        }
    }
}
