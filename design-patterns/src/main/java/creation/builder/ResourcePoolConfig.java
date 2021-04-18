package creation.builder;

import java.util.Objects;

/**
 * @author zhaopc
 * @date 2021/4/18 17:34
 */
public class ResourcePoolConfig {

    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig build(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
        return this;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 10;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build() {
            if (Objects.isNull(name)) {
                throw new IllegalArgumentException("name cannot be null");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxIdle不能大于maxTotal");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("minIdle不能大于maxTotal或者maxIdle");
            }
            return new ResourcePoolConfig().build(this);
        }

        public Builder name(String name) {
            if (Objects.isNull(name)) {
                throw new IllegalArgumentException("name cannot be null");
            }
            this.name = name;
            return this;
        }

        public Builder maxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder maxIdle(int maxIdle) {
            if(maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxIdle不能大于maxTotal");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder minIdle(int minIdle) {
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("minIdle不能大于maxTotal或者maxIdle");
            }
            this.minIdle = minIdle;
            return this;
        }
    }
}
