package cn.cactusli.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.cactusli.domain.strategy.model.entity
 * Description:
 *  抽奖因子实体
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/15 17:37
 * @Github https://github.com/lixuanfengs
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleFactorEntity {

    /** 用户ID */
    private String userId;
    /** 策略ID */
    private Long strategyId;
}
