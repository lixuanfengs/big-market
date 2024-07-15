package cn.cactusli.infrastructure.persistent.dao;

import cn.cactusli.infrastructure.persistent.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.cactusli.infrastructure.persistent.dao
 * Description:
 *  抽奖策略 DAO
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/8 10:25
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface IStrategyDao {

    List<Strategy> queryStrategyList();

    Strategy queryStrategyByStrategyId(Long strategyId);

}
