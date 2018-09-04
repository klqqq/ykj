package com.ykj.java.modules.app.service.impl;

import com.ykj.java.modules.app.dao.GoodsCustomDao;
import com.ykj.java.modules.app.service.GoodsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Author:   yrx
 * Date:     2018/9/4 16:11
 * 自定义商品管理
 **/
@Service("goodsCustomService")
public class GoodsCustomServiceImpl implements GoodsCustomService {

    @Autowired
    private GoodsCustomDao goodsCustomDao;

    /**
     * 获取商品自定义分类类别
     * @param shop_id
     * @return
     */
    public List<HashMap<String,Object>> queryCustomList(int shop_id){
        return goodsCustomDao.queryCustomList(shop_id);
    }

    /**
     * 重命名自定义分类名
     * @param productTypeID
     * @param  newName
     */
    public void updateKindsName(int productTypeID,String newName){
        goodsCustomDao.updateKindsName(productTypeID,newName);
    }

}
