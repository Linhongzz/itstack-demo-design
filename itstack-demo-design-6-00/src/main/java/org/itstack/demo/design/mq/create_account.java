package org.itstack.demo.design.mq;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 开户
 */
@Getter
@Setter
public class create_account {

    private String number;      // 开户编号
    private String address;     // 开户地
    private Date accountDate;   // 开户时间
    private String desc;        // 开户描述

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
