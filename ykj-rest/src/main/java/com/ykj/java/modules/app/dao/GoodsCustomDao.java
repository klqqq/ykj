package com.ykj.java.modules.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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
    void updateCustomKindsName(@Param("id") int productTypeID,@Param("newName") String newName);

    /**
     * 新增自定义分类
     * @param map
     */
    void addCustomKinds(HashMap map);

    /**
     * 置顶自定义分类
     * @param id
     */
    void updateCustomKindsTop(@Param("id") int id, @Param("date") Timestamp date);

    /**
     * 取消店铺原先的置顶
     * @param shop_id
     */
    void cancelCustomKindsTop(int shop_id);
}
