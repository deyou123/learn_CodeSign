package com.deyou.design.test;

import com.deyou.design.application.CacheService;
import com.deyou.design.application.CacheServiceImpl;
import com.deyou.design.redis.RedisUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DeYou
 * @date 2022/11/28
 */
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger( RedisUtils.class);
    @Test
    public void test_CacheService() {
        CacheService cacheService = new CacheServiceImpl();

        cacheService.set("user_name_01", "小傅哥", 1);
        String val01 = cacheService.get("user_name_01",1);
        System.out.println(val01);
    }
}