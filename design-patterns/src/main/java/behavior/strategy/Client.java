package behavior.strategy;

/**
 * @author zhaopc
 * @date 2021/5/30 21:08
 */
public class Client {

    public static void main(String[] args) {
        double money = 100;
        DiscountStrategy strategy = DiscountStrategyFactory.getDiscountStrategy("NORMAL");
        double v = strategy.calDiscount(money);
        System.out.println(v);
    }
}
