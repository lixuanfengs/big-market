package cn.cactusli.domain.strategy.service.raffle;

import cn.cactusli.domain.strategy.model.entity.RaffleAwardEntity;
import cn.cactusli.domain.strategy.model.entity.RaffleFactorEntity;
import cn.cactusli.domain.strategy.model.entity.RuleActionEntity;
import cn.cactusli.domain.strategy.model.entity.StrategyEntity;
import cn.cactusli.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.cactusli.domain.strategy.repository.IStrategyRepository;
import cn.cactusli.domain.strategy.service.IRaffleStrategy;
import cn.cactusli.domain.strategy.service.armory.IStrategyDispatch;
import cn.cactusli.domain.strategy.service.rule.factory.DefaultLogicFactory;
import cn.cactusli.types.enums.ResponseCode;
import cn.cactusli.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Package: cn.cactusli.domain.strategy.service.raffle
 * Description:
 *  抽奖策略抽象类，定义抽奖的标准流程
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/16 16:40
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
public abstract class AbstractRaffleStrategy implements IRaffleStrategy {

    // 策略仓储服务
    protected IStrategyRepository iStrategyRepository;
    // 策略调度服务
    protected IStrategyDispatch iStrategyDispatch;

    public AbstractRaffleStrategy(IStrategyRepository iStrategyRepository, IStrategyDispatch iStrategyDispatch) {
        this.iStrategyRepository = iStrategyRepository;
        this.iStrategyDispatch = iStrategyDispatch;
    }



    @Override
    public RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity) {
        // 1. 参数校验
        String userId = raffleFactorEntity.getUserId();
        Long strategyId = raffleFactorEntity.getStrategyId();
        if (StringUtils.isBlank(userId) || null == strategyId) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }

        // 2. 策略查询
        StrategyEntity strategyEntity = iStrategyRepository.queryStrategyEntityByStrategyId(strategyId);

        // 3. 抽奖操作前 - 规则过滤
        RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> ruleActionEntity = this.doCheckRaffleBeforeLogic(RaffleFactorEntity.builder().userId(userId).strategyId(strategyId).build(), strategyEntity.ruleModels());
        if (RuleLogicCheckTypeVO.TAKE_OVER.getCode().equals(ruleActionEntity.getCode())) {
            if (DefaultLogicFactory.LogicModel.RULE_BLACKLIST.getCode().equals(ruleActionEntity.getRuleModel())) {
                // 黑名单返回固定的奖品ID
                return RaffleAwardEntity.builder()
                        .awardId(ruleActionEntity.getData().getAwardId())
                        .build();
            } else if (DefaultLogicFactory.LogicModel.RULE_WIGHT.getCode().equals(ruleActionEntity.getRuleModel())) {
                // 权重根据返回的信息进行抽奖
                RuleActionEntity.RaffleBeforeEntity raffleBeforeEntity = ruleActionEntity.getData();
                String ruleWeightValueKey = raffleBeforeEntity.getRuleWeightValueKey();
                Integer awardId = iStrategyDispatch.getRandomAwardId(strategyId, ruleWeightValueKey);
                return RaffleAwardEntity.builder()
                        .awardId(awardId)
                        .build();
            }
        }
        // 4. 默认抽奖流程
        Integer awardId = iStrategyDispatch.getRandomAwardId(strategyId);

        return RaffleAwardEntity.builder()
                .awardId(awardId)
                .build();
    }

    protected abstract RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> doCheckRaffleBeforeLogic(RaffleFactorEntity raffleFactorEntity, String... logics);

}
