package com.ykj.java.modules.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository("appSaleGoodsDao")
public interface AppSaleGoodsDao {

    int  insertSaleGoods(HashMap<String,Object> map);

}
