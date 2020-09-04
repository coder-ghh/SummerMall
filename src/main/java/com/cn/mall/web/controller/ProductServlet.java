package com.cn.mall.web.controller;



import com.cn.mall.common.PageBean;
import com.cn.mall.common.Result;
import com.cn.mall.pojo.Product;
import com.cn.mall.service.ProductService;
import com.cn.mall.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/product/*")
public class ProductServlet extends BaseServlet {

    ProductService productService = new ProductServiceImpl();


    public void findPage(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        //获取到前台传过来的分类编号
        String categoryId = request.getParameter("categoryId");
        //获取前台传过来的当前页
        String page = request.getParameter("currentPage");
        //获取每页显示的记录数
        String size = request.getParameter("pageSize");

        int cateId=0;
        if(categoryId!=null){
            cateId=Integer.parseInt(categoryId);
        }

        int currenPage=1;  //如果前台没有传递当前页，则默认值为1
        if(page!=null){
            currenPage=Integer.parseInt(page);
        }

        int pageSize=10;//如果前台没有传递每页条数，则默认值为10
        if(size!=null){
            pageSize= Integer.parseInt(size);
        }

        PageBean<Product> pageBean = productService.findPage(cateId, currenPage, pageSize);

        writeJson(response,pageBean);
    }



    public void findByCate(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

        //获取到前台传过来的分类编号
        String cate_id = request.getParameter("cate_id");
        int cateid =0;    //如果用户没有传分类编号，则将分类编号的默认值设置为0，否则转换后正常赋值
        if(cate_id!=null){
            cateid=Integer.parseInt(cate_id);
        }

        //调用业务层根据分类来进行商品的查询
        List<Product> productList = productService.findByCateId(cateid);

        //构建一个结果对象
        Result result = new Result(true,productList,"查询成功");

        writeJson(response,result);


    }


   //商品详情
    public void findByDetailId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        String did = request.getParameter("detailId");
        int detailId = Integer.parseInt(did);
        Product productDetails = productService.findByDetailId(detailId);
        Result result=new Result(true,productDetails,"商品详情信息查询成功");
        writeJson(response,result);
    }


    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        String name = request.getParameter("name");
        String detail_description = request.getParameter("detail_description");
        String thumbnail1 = request.getParameter("thumbnail");
        int cate_id =Integer.parseInt(request.getParameter("cate_id"));
        productService.add(name,cate_id,thumbnail1,detail_description);
        Result result=new Result(true,"商品增加成功");
        writeJson(response,result);
    }

}
