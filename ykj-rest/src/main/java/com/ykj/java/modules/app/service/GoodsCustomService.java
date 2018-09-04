package com.ykj.java.modules.app.service;

import java.util.HashMap;
import java.util.List;

/**
 * Author:   yrx
 * Date:     2018/9/4 16:10
 * 商品管理
 **/
public interface GoodsCustomService {


    /**
     * 获取商品自定义分类类别
     * @param shop_id
     * @return
     */
    List<HashMap<String,Object>> queryCustomList(int shop_id);

    /**
     * 重命名自定义分类名
     * @param productTypeID
     * @param newName
     */
    void updateKindsName(int productTypeID,String newName);
}
