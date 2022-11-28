package com.deyou.demo.design.event.listener;

import com.deyou.demo.design.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DeYou
 * @date 2022/11/16
 */
public class MessageEventListener implements EventListener{

    Logger logger = LoggerFactory.getLogger( MessageEventListener.class );
    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给用户 {} 发送短信通知(短信)：{}", result.getUId(), result.getMsg());
    }
}