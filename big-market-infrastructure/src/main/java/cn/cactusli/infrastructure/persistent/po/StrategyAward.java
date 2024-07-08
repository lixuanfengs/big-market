package cn.cactusli.infrastructure.persistent.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Package: cn.cactusli.infrastructure.persistent.po
 * Description:
 *  抽奖策略奖品明细配置 - 概率、规则
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/8 10:23
 * @Github https://github.com/lixuanfengs
 */
@Data
public class StrategyAward {

    /** 自增ID */
    private Long id;
    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖奖品ID - 内部流转使用 */
    private Integer awardId;
    /** 抽奖奖品标题 */
    private String awardTitle;
    /** 抽奖奖品副标题 */
    private String awardSubtitle;
    /** 奖品库存总量 */
    private Integer awardCount;
    /** 奖品库存剩余 */
    private Integer awardCountSurplus;
    /** 奖品中奖概率 */
    private BigDecimal awardRate;
    /** 规则模型，rule配置的模型同步到此表，便于使用 */
    private String ruleModels;
    /** 排序 */
    private Integer sort;
    /** 创建时间 */
    private Date createTime;
    /** 修改时间 */
    private Date updateTime;


}
