package cn.cactusli.test.domain;

import cn.cactusli.domain.strategy.service.armory.IStrategyArmory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Package: cn.cactusli.test.domain
 * Description:
 *  策略领域测试
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/10 15:47
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {

    @Resource
    private IStrategyArmory strategyArmory;


    /**
     * 策略ID；100001L 装配的时候创建策略表写入到 Redis Map 中
     */
    @Test
    public void test_strategyArmory() {

        boolean success = strategyArmory.assembleLotteryStrategy(100001L);
        log.info("测试结果：{}", success);
    }

    /**
     * 从装配的策略中随机获取奖品ID值
     */
    @Test
    public void test_getAssembleRandomVal() {
        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100001L));
    }

}
