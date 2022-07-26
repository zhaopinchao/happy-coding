package behavior.strategy;

/**
 * @author zhaopc
 * @date 2021/5/30 21:05
 */
public class PromotionDiscountStrategy implements DiscountStrategy{
    @Override
    public double calDiscount(double money) {
        // 促销8折
        System.out.println("促销折扣，8折");
        return money * 0.80;
    }
}
