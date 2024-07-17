package cn.cactusli.domain.strategy.service.annotation;

import cn.cactusli.domain.strategy.service.rule.factory.DefaultLogicFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Package: cn.cactusli.domain.strategy.service.annotation
 * Description:
 *  自定义枚举类型注解
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/15 18:00
 * @Github https://github.com/lixuanfengs
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogicStrategy {

    DefaultLogicFactory.LogicModel logicMode();
}
