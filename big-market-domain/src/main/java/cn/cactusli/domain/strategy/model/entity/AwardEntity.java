package cn.cactusli.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.cactusli.domain.strategy.model.entity
 * Description:
 *  策略结果实体
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/10 14:36
 * @Github https://github.com/lixuanfengs
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AwardEntity {

    /** 用户ID */
    private String userId;
    /** 奖品ID */
    private Integer awardId;

}
