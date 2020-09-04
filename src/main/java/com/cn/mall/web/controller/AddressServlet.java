package com.cn.mall.web.controller;

import com.cn.mall.common.Result;
import com.cn.mall.pojo.Address;
import com.cn.mall.pojo.Member;
import com.cn.mall.service.AddressService;
import com.cn.mall.service.impl.AddressServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/address/*")
public class AddressServlet extends BaseServlet {

    AddressService addressService=new AddressServiceImpl();
    public void findByMember(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        HttpSession session =request.getSession();
        Member member = (Member) session.getAttribute("member");
        Integer id = member.getId();
        List<Address> address = addressService.findByMember(id);
        Result result=new Result(true,address,"address查询成功");
        writeJson(response,result);
    }



    //保存新增的地址
    public void saveAddress(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

        //获取前台传过来的地址信息，并将其它保存到一个Address对象中
        Map<String, String[]> parameterMap = request.getParameterMap();
        Address address = new Address();
        try {
            BeanUtils.populate(address,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //为地址设置对应的会员的id
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        address.setMbr_id(member.getId());


        //调用业务层将地址信息保存到数据库中
        addressService.add(address);

        Result r = new Result(true,"添加成功");
        writeJson(response,r);

    }
}
