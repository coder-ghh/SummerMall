package com.cn.mall.service;


import com.cn.mall.pojo.Orders;

import java.sql.SQLException;

public interface OrderService {

    //添加订单的同时，添加订单项
    public void add(Orders order, String[] ids, String[] amounts) throws SQLException;

    public void update(int status,String orderNumber);
}
