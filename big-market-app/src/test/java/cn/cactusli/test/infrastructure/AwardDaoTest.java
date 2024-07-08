package cn.cactusli.test.infrastructure;

import cn.cactusli.infrastructure.persistent.dao.IAwardDao;
import cn.cactusli.infrastructure.persistent.po.Award;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Package: cn.cactusli.test.infrastructure
 * Description:
 *  奖品持久化单元测试
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/7/8 16:18
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardDaoTest {

    @Resource
    private IAwardDao awardDao;

    @Test
    public void testQueryAwardList() {
        List<Award> awards = awardDao.queryAwardList();
        log.info("奖品列表：{}", awards);
    }
}
