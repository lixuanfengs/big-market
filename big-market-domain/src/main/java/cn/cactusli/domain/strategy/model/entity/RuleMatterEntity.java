package cn.cactusli.domain.strategy.model.entity;

import lombok.Data;

/**
 * Package: cn.cactusli.domain.strategy.model.entity
 * Description:
 *  规则物料实体对象，用于过滤规则的必要参数信息。
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/15 17:39
 * @Github https://github.com/lixuanfengs
 */
@Data
public class RuleMatterEntity {

    /** 用户ID */
    private String userId;
    /** 策略ID */
    private Long strategyId;
    /** 抽奖奖品ID【规则类型为策略，则不需要奖品ID】 */
    private Integer awardId;
    /** 抽奖规则类型【rule_random - 随机值计算、rule_lock - 抽奖几次后解锁、rule_luck_award - 幸运奖(兜底奖品)】 */
    private String ruleModel;

}
