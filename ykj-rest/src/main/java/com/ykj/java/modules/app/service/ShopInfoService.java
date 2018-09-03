package com.ykj.java.modules.app.service;

import java.util.HashMap;

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
     * 查询商家首页信息
     * @param userId
     * @return
     */
    HashMap<String,Object> queryShopInfo(int userId);
}
