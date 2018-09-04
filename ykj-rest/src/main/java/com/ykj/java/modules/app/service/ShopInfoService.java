package com.ykj.java.modules.app.service;

import java.util.HashMap;
import java.util.List;

/**
 * Author:   yrx
 * Date:     2018/9/3 15:18
 * 商家信息管理
 **/
public interface ShopInfoService {

    /**
     * 查询用户是否是商家
     * @param userId
     * @return
     */
    int queryIdentity(int userId);

    /**
     * 查询商家首页信息1
     * @param userId
     * @return
     */
    HashMap<String,Object> queryShopInfo1(int userId);

    /**
     * 返回一个用户的多个店铺简略信息
     * @param userId
     * @return
     */
    List<HashMap<String,Object>> queryShopList(int userId);

    /**
     * 查询商家首页信息2
     * @param storeID
     * @return
     */
    HashMap queryShopInfo2(int storeID);
}
