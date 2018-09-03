package com.ykj.java.modules.app.service.impl;

import com.ykj.java.modules.app.dao.ShopInfoDao;
import com.ykj.java.modules.app.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Author:   yrx
 * Date:     2018/9/3 15:19
 * 商家信息管理
 **/
@Service("shopInfoService")
public class ShopInfoServiceImpl implements ShopInfoService {

    @Autowired
    private ShopInfoDao shopInfoDao;

    /**
     * 查询用户是否是商家
     * @param userId
     * @return
     */
    public int queryIdentity(int userId){
        return shopInfoDao.queryIdentity(userId);
    }

    /**
     * 查询商家首页信息
     * @param userId
     * @return
     */
    public HashMap<String,Object> queryShopInfo(int userId){
        HashMap data=shopInfoDao.queryShopInfo(userId);
        int storeId=(int)data.get("storeId");
        //名称
        String name=data.get("storeName").toString();
        //分类
        int industryId=(int)data.get("industryId");
        //开始日期
        String createTime=data.get("createTime").toString();
        //截止日期
        String expirationTime=data.get("expirationTime").toString();
        //头像
        String mainPicture=data.get("mainPicture").toString();
        //( 粉丝量、订单量、商家引荐数量、代理引荐数量)
        //粉丝量
        int followListCount=shopInfoDao.queryFollowListCount(storeId);
        //订单量
        int orderCount=shopInfoDao.queryOrderCount(storeId);
        //商家结算
        int price;
        //商家引荐

        //代理引荐

        //判断是否需要续费提醒
        HashMap result=new HashMap<String,Object>();

        result.put("shop_id",storeId);

        return  result;
    }
}
