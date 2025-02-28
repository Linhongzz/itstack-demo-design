package org.itstack.demo.design.mq;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单妥投消息
 */
@Setter
@Getter
public class POPOrderDelivered {

    private String uId;     // 用户ID
    private String orderId; // 订单号
    private Date orderTime; // 下单时间
    private Date sku;       // 商品
    private Date skuName;   // 商品名称
    private BigDecimal decimal; // 金额

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
