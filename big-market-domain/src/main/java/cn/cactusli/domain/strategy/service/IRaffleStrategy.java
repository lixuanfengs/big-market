package cn.cactusli.domain.strategy.service;

import cn.cactusli.domain.strategy.model.entity.RaffleAwardEntity;
import cn.cactusli.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * Package: cn.cactusli.domain.strategy.service
 * Description:
 *  抽奖策略接口
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/15 17:43
 * @Github https://github.com/lixuanfengs
 */
public interface IRaffleStrategy {

    /**
     * 执行抽奖
     * @param raffleFactorEntity 抽奖因子实体，根据入参信息计算抽奖结果
     * @return 抽奖奖品实体
     */
    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);
}
