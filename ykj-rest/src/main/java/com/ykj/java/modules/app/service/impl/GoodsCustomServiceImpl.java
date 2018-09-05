package com.ykj.java.modules.app.service.impl;

import com.ykj.java.modules.app.dao.GoodsCustomDao;
import com.ykj.java.modules.app.service.GoodsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public void updateCustomKindsName(int productTypeID,String newName){
        goodsCustomDao.updateCustomKindsName(productTypeID,newName);
    }

    /**
     * 新增自定义分类
     * @param map
     */
    public void addCustomKinds(HashMap map){
        goodsCustomDao.addCustomKinds(map);
    }

    /**
     * 置顶自定义分类
     * @param id
     *@param shop_id
     */
    @Transactional
    public void updateCustomKindsTop(int id,int shop_id){
        Date date=new Date();
        //取消原来的置顶
        goodsCustomDao.cancelCustomKindsTop(shop_id);
        java.sql.Timestamp date1=new java.sql.Timestamp(date.getTime());
        //置顶
        goodsCustomDao.updateCustomKindsTop(id,date1);
    }

}
