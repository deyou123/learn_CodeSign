package com.deyou.design.application;

import java.util.concurrent.TimeUnit;

public interface CacheService {

    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

    public String get(String key, int redisType);
    void set(String user_name_01, String 小傅哥, int i);
}
