package cn.cactusli.infrastructure.persistent.dao;

import cn.cactusli.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.cactusli.infrastructure.persistent.dao
 * Description:
 *  奖品表DAO
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/8 10:24
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface IAwardDao {

    List<Award> queryAwardList();

}
