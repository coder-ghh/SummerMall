package com.cn.mall.service;

import com.cn.mall.pojo.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    public  List<Category> findAll() throws SQLException;

//使用缓存技术来查询分类信息
    public String findAllByRedis() throws SQLException;

}
