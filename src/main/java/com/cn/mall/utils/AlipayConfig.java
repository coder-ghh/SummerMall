package com.cn.mall.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091600521164";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCCaSEe5FCkmvAIyq76E6BNCCscSi6weyxKXX5Z22mzo52ZeuZrwiTR2dXADyKaaljYtbWjHFQ3eCrkE0KonfOxFJ3xef5OF1xgkakL+e7Y6B9wsfqV5Cx1Bw3RN9R4JJntzI7sarvE00de4T9iY4545g2pU2EUUbd5lCSBA+55Z+yDN3lKaT0RTMN62XCeoU4OMWMMLs3oXXIJR32w7tWl92tg5sUxRpVKH92+sMSojO38tPyKHCx0CbS41TL1nPaddggnIYUP3wTqVrvV0eEULcPN2nhqlJOBRqPT4pznr65oD1VZQFHE0aOjpVRBFMHa6MPmxUlZ61zzkOIXesXzAgMBAAECggEAFqghIvbTs+VfMofUIopqXTfAFagluG+N4FWh8AaYtKcGaHXbtnkCYJsR8c4vWtiDGxNmvTHcx85O1VUrTZQzlF5ammtxbSvN1tE3p2cCwhiB7dheCtCbkLFrCyBB/6WMQK47XoOkn6t9SNSlaHiXdhWx5esggKE52RuNxARk2B6gf/4cDweGukZ+/o3zOm/NADkqBNxCN04EhYJk0NN9MEOXelvV8EJ878LTgA5Il/0YCXjawDrENgNh83EAFSP4zqX3NUKcXdhmGF7qIi6YIIWtUhesYqlfHlu/O37wMVvWystmGltetzcmyQZ4iEHy8daW0+Z8gh+FNpUBagLi8QKBgQC/ZCCSAPahDNjksZ8vG1EVpYV3ulo4YHPbG+ksmqtIIIU4XVcGTLlmm2ntLjnXEae/nwlCHBOXWbO3gRyfKTRs8TE8NMsyQfFrZcySgjFw6HkX4jlPoKo1BilgCXtfJN+ZdjrYQuDgJ/LUJSpCKnADuiw9anQVXhCF4fqc6TOzRQKBgQCubx4v4kGwtPevufZcIACBb4C+thoI4eMePr0w3ODkzwpUhAyRm71QzqSZTroYTWzkeLig/7Gx/9vyuMGgYt5PEPqDefaYlW6F2YFtKHEJFIHFmiBFj3aVKt9xlacOoNyUUsaSz+usX0SSbJm0FwmT6H4YcGqOOEpf24f4fQJL1wKBgFXjNwKOUB8hxsuKMidPmOmf5+88v3QBRLyVH+SWXDr37RDIQl9fWuwC3lxDnE05bQ/+7IawVtJavN2ioReDxDUHX9Lm1jDtistpWY59wnYqvPzM1m83aGp3I2YnmyetQnJ5rhqSmJu/EafGLdqXdMEXcPb2qLVWCxApwu9bb4oJAoGAev+XhaRBNd0lmh/C/AsE0EBTxCacDQ9bGwSaW04ktrLXUekbA8GRqN1Na1z8FA7kbeZCKiSipCUKbwigX/vXTmFmhDcID2evW2qXvOT7b6+qIjAf+WzD7UMh8/HWrpX3dA86PmOmhxFWRPmXGEn2UvlpkMoUGNzQdO9T3YAoklkCgYB0HwmIfLcGsvepMVaWKpEXJ8G/Hhaielr7muHCy/dBhF7/q1Rnz2AEsOGtF/+JlC0o4kiBTO19bx1yTIX1af86W0TlOe1W3CBmG4ZuzUE+i/D1BTTPtQQInmx2hjSILj2h0aRT+zSADkF/qiXcGGndFox3aBgazu7Y4mZQunX+kQ==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxQFuN2OXcEdHEaNLa29SrNRqMsDBbHr09wjaF8vpFWdR/SumspTEChdasEmYG1oJYZ83carXStH5kdRPebDjvg/rGAUFw7EzITxI1dyHAvKwE8d/ZeXu24pbV2VFF1soi0U3HqhGoIH232j/NHFgnf4Y9kdyG4K6dq6u5qwEjr+0bwlR1H/9PEZMPbDWhtF8ydJvobj+bXzwX+FNMjXoRrMus/aTrBrOchD3dZARKvEv8TbIPq9jZvh+SYoOiBrsxJdXSpy/FBWzIk4UZiPZGaGpGTrDEAgEIDYk6/Wry2x8OlNy65b9aUAsh3EduzMzZwor/UtJ+5rupEXY1V6hcwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
    public static String notify_url = "http://localhost:82/pay/alipayNotifyNotice";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //当支付成功之后，通知我们服务（服务器必须定义一个servlet或jsp来接收apli的通知）
    public static String return_url = "http://localhost:82/pay/alipayReturnNotice";


    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
