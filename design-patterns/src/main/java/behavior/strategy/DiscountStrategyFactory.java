package behavior.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaopc
 * @date 2021/5/30 21:06
 */
public class DiscountStrategyFactory {

    private static final Map<String, DiscountStrategy> strategies = new HashMap<>();

    static {
        strategies.put("NORMAL", new NormalDiscountStrategy());
        strategies.put("GROUPON", new GrouponDiscountStrategy());
        strategies.put("PROMOTION", new PromotionDiscountStrategy());
    }

    public static DiscountStrategy getDiscountStrategy(String type) {
        return strategies.get(type);
    }
}
