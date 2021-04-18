package creation.builder;

/**
 * @author zhaopc
 * @date 2021/4/18 17:50
 */
public class BuilderClient {

    public static void main(String[] args) {
        ResourcePoolConfig config = ResourcePoolConfig.builder()
                .name("hello builder")
                .maxTotal(10)
                .maxIdle(10)
                .minIdle(0)
                .build();
    }
}
