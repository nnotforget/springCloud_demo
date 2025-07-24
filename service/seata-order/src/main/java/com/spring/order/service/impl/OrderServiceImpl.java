package com.spring.order.service.impl;

import com.spring.order.bean.OrderTbl;
import com.spring.order.feign.AccountFeignClient;
import com.spring.order.mapper.OrderTblMapper;
import com.spring.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderTblMapper orderTblMapper;



    @Autowired
    AccountFeignClient accountFeignClient;

    @Transactional
    @Override
    public OrderTbl create(String userId, String commodityCode, int orderCount) {
        //1、计算订单价格
        int orderMoney = calculate(commodityCode, orderCount);

        //2、扣减账户余额
        accountFeignClient.debit(userId, orderMoney);
        //3、保存订单
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId(userId);
        orderTbl.setCommodityCode(commodityCode);
        orderTbl.setCount(orderCount);
        orderTbl.setMoney(orderMoney);

        //3、保存订单
        orderTblMapper.insert(orderTbl);
        return orderTbl;
    }

    // 计算价格
    private int calculate(String commodityCode, int orderCount) {
        return 9*orderCount;
    }
}
