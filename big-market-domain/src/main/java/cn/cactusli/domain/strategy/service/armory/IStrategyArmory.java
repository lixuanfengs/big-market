package cn.cactusli.domain.strategy.service.armory;

/**
 * Package: cn.cactusli.domain.strategy.service.armory
 * Description:
 *  策略装配库(兵工厂)，负责初始化策略计算
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/10 14:39
 * @Github https://github.com/lixuanfengs
 */
public interface IStrategyArmory {

    /**
     * 装配抽奖策略配置「触发的时机可以为活动审核通过后进行调用」
     *
     * @param strategyId 策略ID
     * @return 装配结果
     */
    boolean assembleLotteryStrategy(Long strategyId);

}
