package com.ykj.java.modules.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Author:   yrx
 * Date:     2018/9/4 16:16
 * 自定义商品管理
 **/
@Mapper
@Repository("GoodsCustomDao")
public interface GoodsCustomDao {

    /**
     * 获取商品自定义分类类别
     * @param shop_id
     * @return
     */
    List<HashMap<String,Object>> queryCustomList(int shop_id);

    /**
     * 重命名自定义分类名
     * @param productTypeID
     */
    void updateKindsName(@Param("id") int productTypeID,@Param("newName") String newName);
}
