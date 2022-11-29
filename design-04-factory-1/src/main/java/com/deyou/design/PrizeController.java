package com.deyou.design;

import com.alibaba.fastjson.JSON;
import com.deyou.design.card.IQiYiCardService;
import com.deyou.design.coupon.CouponResult;
import com.deyou.design.coupon.CouponService;
import com.deyou.design.goods.DeliverReq;
import com.deyou.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DeYou
 * @date 2022/11/28
 */
public class PrizeController {

    private Logger logger = LoggerFactory.getLogger( PrizeController.class );

    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString( req );
        AwardRes awardRes = null;

        try {
            logger.info( "奖品发放开始{}。req:{}", req.getUId(), reqJson );
            //发放
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon( req.getUId(), req.getAwardNumber(), req.getBizId() );
                if ("0000".equals( couponResult.getCode() )) {
                    awardRes = new AwardRes( "0000", "发放成功" );
                } else {
                    awardRes = new AwardRes( "0001", couponResult.getInfo() );
                }
            }else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName( queryUserName( req.getUId() ) );
                deliverReq.setUserPhone( queryUserPhoneNumber( req.getUId() ) );
                deliverReq.setSku( req.getAwardNumber() );
                deliverReq.setOrderId( req.getBizId() );
                deliverReq.setConsigneeUserName( req.getExtMap().get( "consigneeUserName" ) );
                deliverReq.setConsigneeUserPhone( req.getExtMap().get( "consigneeUserPhone" ) );
                deliverReq.setConsigneeUserAddress( req.getExtMap().get( "consigneeUserAddress" ) );
                Boolean isSuccess = goodsService.deliverGoods( deliverReq );
                if (isSuccess) {
                    awardRes = new AwardRes( "0000", "发放成功" );
                } else {
                    awardRes = new AwardRes( "0001", "发放失败" );
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber( req.getUId() );
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken( bindMobileNumber, req.getAwardNumber() );
                awardRes = new AwardRes( "0000", "发放成功" );
            }
            logger.info( "奖品发放完成{}。", req.getUId() );
        } catch(Exception e){
            logger.error( "奖品发放失败{}。req:{}", req.getUId(), reqJson, e );
            awardRes = new AwardRes( "0001", e.getMessage() );
        }

        return awardRes;
    }


    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }
}