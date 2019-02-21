package com.jk.mapper;


import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodMapper {

    Class1 getvalue(String id);

    Class2 getClass2(String id);

    List<MallSku> getGoodName(Integer id);

    List<TradeMark> getTrade(String id);

    List<MallValue> getValue(String id);

    List<MallAttr> getSx(String id);

    MallSku getAll(Integer id);

    List<Shoping> getgoulist();

    void deleteItem(String ids);

    List<Shoping> queryGood(Integer yh_id);

    Integer countGood(Integer yh_id);

    List <Shoping> getgouwu(Integer yhid);

    List<Shoping> jieSuanCheckPrice(@Param("ids") String ids);

    @Update("update t_mall_shoppingcar m set  m.tjshl = m.tjshl+1 , m.hj = m.hj+#{price} where m.id = #{id} ")
    void updateSl(@Param("id") Integer id,@Param("price") Double price);


    @Update("update t_mall_shoppingcar m set  m.tjshl = m.tjshl-1 , m.hj = m.hj-#{price}  where m.id = #{id}")
    void updateSl1(@Param("id") Integer id,@Param("price") Double price);
}
