package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Book;
import com.jk.utils.RestClientFactory;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class EsController {

    @ResponseBody
    @RequestMapping("addBook")
    public String addBook(Book book) {

        //1.获取ES的连接
        RestHighLevelClient client = RestClientFactory.getHighLevelClient();

        //指定存放的位置"
        IndexRequest indexRequest = new IndexRequest("test02", "book", "1");

        //book对象-->JSON字符串
        String jsonString = JSONObject.toJSONString(book);

        //存放数据
        indexRequest.source(jsonString, XContentType.JSON);
/*
        try {
            IndexResponse index = client.index(indexRequest);//同步的方式
            System.out.println(index);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        //new实际上是一个匿名类


        client.indexAsync(indexRequest, new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {//方法的回调
                System.out.println(indexResponse);
                System.out.println("22222222222222222");
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("333333333333333333");
            }
        });

        System.out.println("11111111111111");


        return "";
    }
}
