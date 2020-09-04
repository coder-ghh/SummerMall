package com.cn.mall.service;

import com.cn.mall.common.PageBean;
import com.cn.mall.pojo.Product;


import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    //根据商品分类进行查询
    public List<Product> findByCateId(int cateid);

    //根据商品分类进行分页查询
    public PageBean<Product> findPage(int cateid, int currentPage, int pageSize);

    //查询商品详情
    public  Product findByDetailId(int id) throws SQLException;

    public void add(String name,int cate_id,String thumbnail1,String detail_description) throws SQLException;
}
