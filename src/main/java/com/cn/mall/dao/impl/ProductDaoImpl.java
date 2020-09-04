package com.cn.mall.dao.impl;


import com.cn.mall.dao.ProductDao;
import com.cn.mall.pojo.Product;
import com.cn.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    QueryRunner runner =  new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public List<Product> findByCateId(int cateid) {

        String sql = "select * from product where cate_id=?";
        try {
            List<Product> productList = runner.query(sql, new BeanListHandler<>(Product.class), cateid);
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public long findTotalCount(int cateid)  {
        String sql ="select count(*) from product where cate_id=?";
        Long totalCount = 0L;
        try {
            totalCount = runner.query(sql, new ScalarHandler<Long>(), cateid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalCount;
    }


    @Override
    public List<Product> findByPage(int cateid, int start, int pageSize) {

        String sql = "select * from product where cate_id=? limit ?,?";
        try {
            List<Product> productList = runner.query(sql, new BeanListHandler<>(Product.class),cateid, start, pageSize);
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   //商品详情
    @Override
    public Product findByDetailId(int id) throws SQLException {
        String sql="select * from product where id=?";
        Product detail = runner.query(sql, new BeanHandler<>(Product.class), id);
        return detail;
    }

    @Override
    public int add(String name, int cate_id, String thumbnail1, String detail_description) throws SQLException {
        String sql="insert into product values(null,?,?,?,?,?,?,?,?,?,?,?)";

        return runner.update(sql, name,cate_id,thumbnail1,null,null,null,null, detail_description,null ,null,null );
    }



//    @Override
//    public void add(String name, String detail_description, String thumbnail1, String cate_id) throws SQLException {
//        String sql="insert into product values(null,?,?,?,?,?,?,?,?,?,?,?)";
//        runner.update(sql, name, detail_description, thumbnail1, cate_id);
//    }



//    @Override
//    public void add(String name, String detail_description, String thumbnail1, int cate_id,int inventory,int sales_volume,String price,String sale_price,String selling_description,Date create_time,Date sale_time ) throws SQLException {
//        String sql="insert into product values(null,?,?,?,?,?,?,?,?,?,?,?)";
//        runner.update(sql,name,cate_id,thumbnail1,null,null,null,null,detail_description,null,null,null);
//
//    }


}
