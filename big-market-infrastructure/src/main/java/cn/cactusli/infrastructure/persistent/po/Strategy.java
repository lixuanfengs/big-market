package cn.cactusli.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * Package: cn.cactusli.infrastructure.persistent.po
 * Description:
 *  抽奖策略
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/8 10:23
 * @Github https://github.com/lixuanfengs
 */
@Data
public class Strategy {

    /** 自增ID */
    private Long id;
    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖策略描述 */
    private String strategyDesc;
    /** 抽奖规则模型 */
    private String ruleModels;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
