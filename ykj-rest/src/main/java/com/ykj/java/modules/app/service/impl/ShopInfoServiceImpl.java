package com.ykj.java.modules.app.service.impl;

import com.ykj.java.modules.app.dao.ShopInfoDao;
import com.ykj.java.modules.app.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
     * 查询商家首页信息（只有一个店铺的商家）
     * @param userId
     * @return
     */
    public HashMap<String,Object> queryShopInfo1(int userId){
        HashMap data=shopInfoDao.queryShopInfoByUserId(userId);
        HashMap result=new HashMap<String,Object>();
        int storeId=(int)data.get("storeID");
        result.put("shop_id",storeId);
        //名称
        String name=data.get("storeName").toString();
        result.put("name",name);
        //分类
        int industryId=(int)data.get("industryID");
        result.put("industryId",industryId);
        //开始日期
        String createTime=data.get("createTime").toString();
        result.put("createTime",createTime);
        //截止日期
        String expirationTime=data.get("expirationTime").toString();
        result.put("expirationTime",expirationTime);
        //头像
        String mainPicture=data.get("mainPictures").toString();
        result.put("mainPicture",mainPicture);
        //粉丝量
        int followListCount=shopInfoDao.queryFollowListCount(storeId);
        result.put("followListCount",followListCount);
        //订单量
        int orderCount=shopInfoDao.queryOrderCount(storeId);
        result.put("orderCount",orderCount);
        //待核销订单数量
        int notUserOrder=shopInfoDao.queryNotUserOrderCount(storeId);
        result.put("notUserOrder",notUserOrder);
        //商家结算
        int price=0;
        result.put("price",price);
        //商家引荐
        int shopRecommend=0;
        result.put("shopRecommend",shopRecommend);
        //代理引荐
        int AgencyRecommend=0;
        result.put("AgencyRecommend",AgencyRecommend);
        //判断是否需要续费提醒
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date begin;
        Date end;
        long day=-1;
        try {
            begin=sdf.parse(createTime);
            end=sdf.parse(expirationTime);
            day=(end.getTime()-begin.getTime())/(24*60*60*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int renewals;
        if (day>30)
            renewals=0;
        else if ((day>=0&&day<30))
            renewals=1;
        else
            renewals=-1;
        System.out.println(day);
        result.put("renewals",renewals);
        return  result;
    }

    /**
     * 返回一个用户的多个店铺简略信息
     * @param userId
     * @return
     */
    public List<HashMap<String,Object>> queryShopList(int userId){
        //查询用户拥有的所有店铺
        List<Integer> shopList=shopInfoDao.queryShopList(userId);
        List<HashMap<String,Object>> result=new ArrayList<>();
        for(int storeID:shopList){
            HashMap shop=shopInfoDao.queryShopInfoByShopId(storeID);
            String storeName=shop.get("storeName").toString();
            String mainPictures=shop.get("mainPictures").toString();
            String address=shop.get("address").toString();
            HashMap data=new HashMap();
            data.put("storeName",storeName);
            data.put("mainPictures",mainPictures);
            data.put("address",address);
            data.put("storeID",storeID);
            result.add(data);
        }
        //查询一个店铺信息
        return result;
    }

    /**
     * 查询商家首页信息2
     * @param storeID
     * @return
     */
    public HashMap queryShopInfo2(int storeID){
        HashMap data=shopInfoDao.queryShopInfoByShopId(storeID);
        HashMap result=new HashMap<String,Object>();
        int storeId=(int)data.get("storeID");
        result.put("shop_id",storeId);
        //名称
        String name=data.get("storeName").toString();
        result.put("name",name);
        //分类
        int industryId=(int)data.get("industryID");
        result.put("industryId",industryId);
        //开始日期
        String createTime=data.get("createTime").toString();
        result.put("createTime",createTime);
        //截止日期
        String expirationTime=data.get("expirationTime").toString();
        result.put("expirationTime",expirationTime);
        //头像
        String mainPicture=data.get("mainPictures").toString();
        result.put("mainPicture",mainPicture);
        //粉丝量
        int followListCount=shopInfoDao.queryFollowListCount(storeId);
        result.put("followListCount",followListCount);
        //订单量
        int orderCount=shopInfoDao.queryOrderCount(storeId);
        result.put("orderCount",orderCount);
        //待核销订单数量
        int notUserOrder=shopInfoDao.queryNotUserOrderCount(storeId);
        result.put("notUserOrder",notUserOrder);
        //商家结算
        int price=0;
        result.put("price",price);
        //商家引荐
        int shopRecommend=0;
        result.put("shopRecommend",shopRecommend);
        //代理引荐
        int AgencyRecommend=0;
        result.put("AgencyRecommend",AgencyRecommend);
        //判断是否需要续费提醒
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date begin;
        Date end;
        long day=-1;
        try {
            begin=sdf.parse(createTime);
            end=sdf.parse(expirationTime);
            day=(end.getTime()-begin.getTime())/(24*60*60*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int renewals;
        if (day>30)
            renewals=0;
        else if ((day>=0&&day<30))
            renewals=1;
        else
            renewals=-1;
        result.put("renewals",renewals);
        return  result;
    }
}
