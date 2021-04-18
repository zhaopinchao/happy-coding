package creation.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhaopc
 * @date 2021/4/18 22:21
 */
public class Singleton {

    // 1.饿汉模式
    public static final IdGenerator ID_GENERATOR = new IdGenerator();

    // 2.懒汉模式
    private IdGenerator idGenerator;

    public IdGenerator getIdGenerator() {
        if (idGenerator == null) {
            synchronized (Singleton.class) {
                if (idGenerator == null) {
                    idGenerator = new IdGenerator();
                }

            }
        }
        return idGenerator;
    }

    //3.静态内部类

    private static class SingletonHelper {
        private static final IdGenerator ID_GENERATOR = new IdGenerator();
    }

    public IdGenerator getIdGenerator1() {
        return SingletonHelper.ID_GENERATOR;
    }
}

//4.枚举
enum IdGeneratorEnum {
    /**
     * id生成器实例
     */
    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
