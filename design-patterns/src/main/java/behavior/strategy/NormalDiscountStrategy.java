package behavior.strategy;

/**
 * 普通打折策略
 * @author zhaopc
 * @date 2021/5/30 20:56
 */
public class NormalDiscountStrategy implements DiscountStrategy {

    @Override
    public double calDiscount(double money) {
        // 98折
        System.out.println("普通折扣， 98折");
        return money * 0.98;
    }
}
