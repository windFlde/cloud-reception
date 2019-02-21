package com.jk.service.impl;


import com.github.pagehelper.PageHelper;
import com.jk.bean.*;

import com.jk.mapper.GoodMapper;
import com.jk.service.GoodService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Resource
    private GoodMapper goodMapper;

    @Override
    public Class1 getvalue(String id) {
        return goodMapper.getvalue(id);
    }

    @Override
    public Class2 getClass2(String id) {
        return goodMapper.getClass2(id);
    }
    @Override
    public List<MallSku> getGoodName(Integer id) {
        return   goodMapper.getGoodName(id);
    }

    @Override
    public List<TradeMark> getTrade(String id) {
        return goodMapper.getTrade(id);
    }

    @Override
    public List<MallValue> getValue(String id) {
        return goodMapper.getValue(id);
    }

    @Override
    public List<MallAttr> getSx(String id) {
        return goodMapper.getSx(id);
    }

    @Override
    public MallSku getAll(Integer id) {

        return goodMapper.getAll(id);
    }

    @Override
    public SendPage getgoulist(ReceivePage receivePage) {
        List <Shoping> sum=goodMapper.getgoulist(); //计算数据库符合条件的总条数   条数是固
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List <Shoping> list=goodMapper.getgoulist(); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage=new SendPage(sum.size(),list);
        return sendPage;
    }

    @Override
    public void deleteItem(String ids) {
        goodMapper.deleteItem(ids);
    }

    @Override
    public List<Shoping> queryGood(Integer yh_id) {
        return goodMapper.queryGood(yh_id);
    }

    @Override
    public Integer countGood(Integer yh_id) {
        return goodMapper.countGood(yh_id);
    }

    @Override
    public List <Shoping> getgouwu(Integer yhid) {
        List <Shoping> li=goodMapper.getgouwu(yhid);
        return li;
    }

    @Override
    public  List<Shoping>  jieSuanCheckPrice(String ids) {
        List<Shoping>  price = goodMapper.jieSuanCheckPrice(ids);
        return price;
    }

    @Override
    public void updateSl(Integer state, Integer id, Double price) {
        if(state==1){
            goodMapper.updateSl(id, price);
        }else if (state==2){
            goodMapper.updateSl1(id,price);
        }
    }

}
