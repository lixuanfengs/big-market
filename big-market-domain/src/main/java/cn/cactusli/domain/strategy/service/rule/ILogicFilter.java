package cn.cactusli.domain.strategy.service.rule;

import cn.cactusli.domain.strategy.model.entity.RuleActionEntity;
import cn.cactusli.domain.strategy.model.entity.RuleMatterEntity;

/**
 * Package: cn.cactusli.domain.strategy.service.rule
 * Description:
 *  抽奖规则过滤接口
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/15 17:50
 * @Github https://github.com/lixuanfengs
 */
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);

}
