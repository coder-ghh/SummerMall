package com.cn.mall.service.impl;


import com.cn.mall.dao.ItemDao;
import com.cn.mall.dao.OrderDao;
import com.cn.mall.dao.ProductDao;
import com.cn.mall.dao.impl.ItemDaoImpl;
import com.cn.mall.dao.impl.OrderDaoImpl;
import com.cn.mall.dao.impl.ProductDaoImpl;
import com.cn.mall.pojo.Item;
import com.cn.mall.pojo.Orders;
import com.cn.mall.pojo.Product;
import com.cn.mall.service.OrderService;

import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao =new OrderDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    ItemDao itemDao = new ItemDaoImpl();


    @Override
    public void add(Orders order, String[] ids, String[] amounts) throws SQLException {
        //添加订单，同时将订单的id返回
        int orderId = orderDao.add(order);

        //添加订单项
        for(int i=0; i<ids.length; i++){
            //创建订单项对象
            Item item = new Item();
            item.setOrder_id(orderId);          //设置订单id
            item.setProduct_id(Integer.parseInt(ids[i])); //设置商品id
            item.setAmount(Integer.parseInt(amounts[i])); //设置当前订单项的数量

            Product product = productDao.findByDetailId(Integer.parseInt(ids[i]));
            item.setTotal_price(product.getPrice()*Integer.parseInt(amounts[i]));
            item.setPayment_price(product.getSale_price()*Integer.parseInt(amounts[i]));
            itemDao.add(item);
        }
    }

    @Override
    public void update(int status, String orderNumber) {
        orderDao.update(status,orderNumber);
    }
}
