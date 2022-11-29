package com.deyou.design.service;

import java.util.Map;

/**
 * @author DeYou
 * @date 2022/11/28
 */
public interface ICommodity {

    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;

}