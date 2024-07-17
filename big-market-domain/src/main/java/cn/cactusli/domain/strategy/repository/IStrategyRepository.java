package cn.cactusli.domain.strategy.repository;

import cn.cactusli.domain.strategy.model.entity.StrategyAwardEntity;
import cn.cactusli.domain.strategy.model.entity.StrategyEntity;
import cn.cactusli.domain.strategy.model.entity.StrategyRuleEntity;

import java.util.List;
import java.util.Map;

/**
 * Package: cn.cactusli.domain.strategy.repository
 * Description:
 *  策略服务仓储接口
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/10 14:38
 * @Github https://github.com/lixuanfengs
 */
public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

}
