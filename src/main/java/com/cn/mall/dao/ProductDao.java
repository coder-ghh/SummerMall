package com.cn.mall.dao;



import com.cn.mall.pojo.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    //根据商品分类进行查询
    public List<Product> findByCateId(int cateid);

    //查询当前分类商品的总记录数
    public long findTotalCount(int cateid);

    //查询当前的集合信息
    public List<Product> findByPage(int cateid, int start, int pageSize);

    //查询商品详情
    public  Product findByDetailId(int id) throws SQLException;



    public int add(String name, int cate_id,String thumbnail1,String detail_description) throws SQLException;
}
