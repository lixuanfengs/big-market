package cn.cactusli.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.SecureRandom;

@Slf4j
public class ApiTest {

    @Test
    public void test() {


        int i = new SecureRandom().nextInt(6);
        log.info("测试完成" + i);
    }



}
