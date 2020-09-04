package com.cn.mall.web.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.cn.mall.service.OrderService;
import com.cn.mall.service.impl.OrderServiceImpl;
import com.cn.mall.utils.AlipayConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
@WebServlet("/pay/*")
public class PayServlet extends  BaseServlet {
    OrderService orderService = new OrderServiceImpl();
    //接收支付宝返回通知
    public void alipayReturnNotice(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号

        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //支付宝交易号

        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        //计算得出通知验证结果
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        //验证上面的信息是不是由支付宝给我们返回的
        boolean verify_result = false;
        try {
            verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, "RSA2");
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        if(verify_result){//验证成功

            //如果用户支付成功
            //1、将订单的状态修改为1(已支付)
            orderService.update(1,out_trade_no);
            //2、要将产品的销售数量加1


            out.println("支付成功<br />");

        }else{
            //该页面可做页面美工编辑

            out.println("支付失败");
        }
    }
}
