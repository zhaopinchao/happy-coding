package creation.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhaopc
 * @date 2021/4/18 22:23
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
