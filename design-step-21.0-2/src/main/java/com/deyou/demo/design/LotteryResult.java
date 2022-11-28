package com.deyou.demo.design;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author DeYou
 * @date 2022/11/15
 */
@Data
@AllArgsConstructor
public class LotteryResult {

    private String uId;    // 用户ID
    private String msg;    // 摇号信息
    private Date dateTime; // 业务时间
}