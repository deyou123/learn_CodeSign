package com.deyou.demo.design.event.listener;

import com.deyou.demo.design.LotteryResult;

/**
 * @author DeYou
 * @date 2022/11/16
 */
public interface EventListener {
    /**
     * 接受结果
     * @param result
     */
    void doEvent(LotteryResult result);
}