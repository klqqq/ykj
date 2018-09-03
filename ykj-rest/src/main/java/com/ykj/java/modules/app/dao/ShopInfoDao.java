package com.ykj.java.modules.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Author:   yrx
 * Date:     2018/9/3 15:28
 * 商家信息管理
 **/
@Mapper
@Repository("shopInfoDao")
public interface ShopInfoDao {

    /**
     * 查询用户是否是商家
     * @param userId
     * @return
     */
    int queryIdentity(int userId);

    /**
     * 查询商家信息
     * @param userId
     * @return
     */
    HashMap<String,Object> queryShopInfo(int userId);

    /**
     * 统计店铺粉丝数量
     * @param storeId
     * @return
     */
    int queryFollowListCount(int storeId);

    /**
     * 统计店铺订单量
     * @param storeId
     * @return
     */
    int queryOrderCount(int storeId);
}
