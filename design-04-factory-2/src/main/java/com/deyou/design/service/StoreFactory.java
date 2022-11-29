package com.deyou.design.service;

import com.deyou.design.service.impl.CardCommodityService;
import com.deyou.design.service.impl.CouponCommodityService;
import com.deyou.design.service.impl.GoodsCommodityService;

/**
 * @author DeYou
 * @date 2022/11/28
 */
public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }

}