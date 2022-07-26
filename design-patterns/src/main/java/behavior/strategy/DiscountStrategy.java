package behavior.strategy;

/**
 * 折扣策略
 *
 * @author zhaopc
 * @date 2021/5/30 20:55
 */
public interface DiscountStrategy {

    /**
     * 打折计算
     *
     * @param money 钱
     * @return double
     */
    double calDiscount(double money);
}
