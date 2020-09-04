package com.cn.mall.dao.impl;

import com.cn.mall.dao.CategoryDao;
import com.cn.mall.pojo.Category;
import com.cn.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    //创建QueryRunner对象来访问数据库
    QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() throws SQLException {
       String sql="select * from category";
        List<Category> list = runner.query(sql, new BeanListHandler<>(Category.class));
        return list;
    }
}
