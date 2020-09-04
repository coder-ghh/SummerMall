package com.cn.mall.web.controller;

import com.cn.mall.common.Result;
import com.cn.mall.pojo.Category;
import com.cn.mall.service.CategoryService;
import com.cn.mall.service.impl.CategoryServiceImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends  BaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
 /*  List<Category> categoryList = categoryService.findAll();

        Result result = new Result();
        result.setFlag(true);
        result.setMsg("查询成功");
        result.setData(categoryList);

        writeJson(response,result);*/

        response.setContentType("application/json");
        String allByRedis = categoryService.findAllByRedis(); //返回的就是json数据

        response.getWriter().print(allByRedis);

    }
}
