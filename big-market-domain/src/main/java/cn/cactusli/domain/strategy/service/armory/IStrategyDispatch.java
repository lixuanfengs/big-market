package cn.cactusli.domain.strategy.service.armory;

/**
 * Package: cn.cactusli.domain.strategy.service.armory
 * Description:
 *  策略抽奖调度
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/11 16:50
 * @Github https://github.com/lixuanfengs
 */
public interface IStrategyDispatch {

    /**
     * 获取抽奖策略装配的随机结果
     *
     * @param strategyId 策略ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);

}
