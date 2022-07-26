package behavior.strategy;

/**
 * @author zhaopc
 * @date 2021/5/30 21:04
 */
public class GrouponDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(double money) {
        // 团购9折
        System.out.println("团购折扣，9折");
        return money * 0.90;
    }
}
