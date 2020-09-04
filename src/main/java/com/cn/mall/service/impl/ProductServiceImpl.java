package com.cn.mall.service.impl;

import com.cn.mall.common.PageBean;
import com.cn.mall.dao.ProductDao;
import com.cn.mall.dao.impl.ProductDaoImpl;
import com.cn.mall.pojo.Product;
import com.cn.mall.service.ProductService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> findByCateId(int cateid) {
        return productDao.findByCateId(cateid);
    }


    @Override
    public PageBean<Product> findPage(int cateid, int currentPage, int pageSize) {
        //获取当前分类的总记录数
        long totalCount = productDao.findTotalCount(cateid);
        //获取总页数
        long totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        if(currentPage<=0){
          currentPage=1;
        }

        if (currentPage>totalPage){
            currentPage=(int)totalPage;
        }
        //获取一个存有分页商品的集合
        //将当前页转换成一个起始位置
        int start = (currentPage-1)*pageSize;
        List<Product> productList = productDao.findByPage(cateid, start, pageSize);

        //构建一个PageBean对象
        PageBean<Product> pageBean =new PageBean<>();
        pageBean.setList(productList);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

    //商品详情
    @Override
    public Product findByDetailId(int id) throws SQLException {
        Product detail = productDao.findByDetailId(id);

        return detail;
    }

    @Override
    public void add(String name, int cate_id, String thumbnail1, String detail_description) throws SQLException {
        productDao.add(name,cate_id,thumbnail1,detail_description);
    }




//    @Override
//    public void add(String name, String detail_description, String thumbnail1, int cate_id, int inventory, int sales_volume, String price, String sale_price, String selling_description, Date create_time, Date sale_time ) throws SQLException {
//        productDao.add(name,detail_description,thumbnail1,cate_id,null,null,null,null,null,null,null);
//    }


}
