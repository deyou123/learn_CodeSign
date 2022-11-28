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

    private String uId;
    private String lottery;
    private Date date;
}