package com.deyou.design.application;


import com.deyou.design.redis.RedisUtils;
import com.deyou.design.redis.cluster.EGM;
import com.deyou.design.redis.cluster.IIR;

import java.util.concurrent.TimeUnit;

public class CacheServiceImpl implements CacheService {

    private RedisUtils redisUtils = new RedisUtils();

    private EGM egm = new EGM();

    private IIR iir = new IIR();


    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public void set(String key, String value) {

    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {

    }

    @Override
    public void del(String key) {

    }

    public void set(String key, String value, int redisType) {

        if (1 == redisType) {
            egm.set(key, value);
            return;
        }

        if (2 == redisType) {
            iir.set(key, value);
            return;
        }

        redisUtils.set(key, value);
    }

    public String get(String key, int redisType) {

        if (1 == redisType) {
            return egm.gain(key);
        }

        if (2 == redisType) {
            return iir.get(key);
        }

        return redisUtils.get(key);
    }
}