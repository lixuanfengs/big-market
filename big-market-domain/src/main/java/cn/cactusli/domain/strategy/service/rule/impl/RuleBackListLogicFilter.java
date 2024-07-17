package cn.cactusli.domain.strategy.service.rule.impl;

import cn.cactusli.domain.strategy.model.entity.RuleActionEntity;
import cn.cactusli.domain.strategy.model.entity.RuleMatterEntity;
import cn.cactusli.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.cactusli.domain.strategy.repository.IStrategyRepository;
import cn.cactusli.domain.strategy.service.annotation.LogicStrategy;
import cn.cactusli.domain.strategy.service.rule.ILogicFilter;
import cn.cactusli.domain.strategy.service.rule.factory.DefaultLogicFactory;
import cn.cactusli.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Package: cn.cactusli.domain.strategy.service.rule.impl
 * Description:
 *  抽奖操作前，黑名单用户过滤规则
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/15 17:57
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@Component
@LogicStrategy(logicMode = DefaultLogicFactory.LogicModel.RULE_BLACKLIST)
public class RuleBackListLogicFilter implements ILogicFilter<RuleActionEntity.RaffleBeforeEntity> {

    @Resource
    private IStrategyRepository iStrategyRepository;

    @Override
    public RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> filter(RuleMatterEntity ruleMatterEntity) {
        log.info("规则过滤-黑名单 userId:{} strategyId:{} ruleModel:{}", ruleMatterEntity.getUserId(), ruleMatterEntity.getStrategyId(), ruleMatterEntity.getRuleModel());
        String userId = ruleMatterEntity.getUserId();
        // 查询规则值配置
        String ruleValue = iStrategyRepository.queryStrategyRuleValue(ruleMatterEntity.getStrategyId(), ruleMatterEntity.getAwardId(), ruleMatterEntity.getRuleModel());
        String[] splitRuleValue = ruleValue.split(Constants.COLON);
        Integer awardId = Integer.parseInt(splitRuleValue[0]);
        // 过滤其他规则
        String[] userBlackIds = splitRuleValue[1].split(Constants.SPLIT);
        for (String userBlackId : userBlackIds) {
            if (userId.equals(userBlackId)) {
                return RuleActionEntity.<RuleActionEntity.RaffleBeforeEntity>builder()
                        .ruleModel(DefaultLogicFactory.LogicModel.RULE_BLACKLIST.getCode())
                        .data(RuleActionEntity.RaffleBeforeEntity.builder()
                                .strategyId(ruleMatterEntity.getStrategyId())
                                .awardId(awardId)
                                .build())
                        .code(RuleLogicCheckTypeVO.TAKE_OVER.getCode())
                        .info(RuleLogicCheckTypeVO.TAKE_OVER.getInfo())
                        .build();
            }
        }

        return RuleActionEntity.<RuleActionEntity.RaffleBeforeEntity>builder()
                .code(RuleLogicCheckTypeVO.ALLOW.getCode())
                .info(RuleLogicCheckTypeVO.ALLOW.getInfo())
                .build();
    }
}
