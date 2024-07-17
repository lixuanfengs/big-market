package cn.cactusli.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactusli.domain.strategy.model.valobj
 * Description:
 *  规则过滤校验类型值对象
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/15 17:38
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum RuleLogicCheckTypeVO {

    ALLOW("0000", "放行；执行后续的流程，不受规则引擎影响"),
    TAKE_OVER("0001","接管；后续的流程，受规则引擎执行结果影响"),
    ;

    private final String code;
    private final String info;

}
