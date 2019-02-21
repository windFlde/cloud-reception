package com.jk.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jk.utils.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("zhifu")
public class OrderController {

    /*//订单列表
    @RequestMapping("SelectOrder")
    @ResponseBody
    public HashMap<String,Object> SelectOrder(Integer page, Integer rows, Order order){
        return orderServcie.SelectOrder(page,rows,order);
    }*/


    /*
    支付
     */
    @RequestMapping("zhifu")
    @ResponseBody
    public String zhifu(Integer jg) throws  Exception{

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        String uuid = UUID.randomUUID().toString();
        String keyUUid = uuid.replaceAll("-", "");
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = keyUUid;
        //付款金额，必填
        Integer total_amount =jg;
        //订单名称，必填
        String subject = "智方科技订单-"+keyUUid;
        //商品描述，可空
        String body = "用户：" + 3;
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result;
    }



}

