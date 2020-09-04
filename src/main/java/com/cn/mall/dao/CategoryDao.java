package com.cn.mall.dao;

import com.cn.mall.pojo.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    public List<Category> findAll() throws SQLException;
}
