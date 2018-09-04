package com.ykj.java.modules.app.controller;

import com.ykj.java.common.utils.AppBaseResult;
import com.ykj.java.modules.app.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Author:   yrx
 * Date:     2018/9/3 14:41
 * 商家中心管理
 **/
@RestController
@RequestMapping("/api/shopCenter")
public class ShopCenterController {

    @Autowired
    private ShopInfoService shopInfoService;

    /**
     * 获取商家中心首页信息
     * @param appBaseResult
     * @return
     */
    @CrossOrigin
    @PostMapping("homepage/info1")
    public AppBaseResult getShopCenterInfo1(@RequestBody AppBaseResult appBaseResult){
        HashMap data = (HashMap) appBaseResult.getData();
        int userId=(int)data.get("userId");
        //计算店铺商量
        int check=shopInfoService.queryIdentity(userId);
        if(check<1)
            return AppBaseResult.error("抱歉，您不是商家用户");
        //一个店铺的情况
        else if(check==1){
            HashMap result=shopInfoService.queryShopInfo1(userId);
            return AppBaseResult.success().setEncryptData(result);
        }
        //多个店铺返回店铺信息列表
        else {
            List<HashMap<String,Object>> shopList=shopInfoService.queryShopList(userId);
            return AppBaseResult.success("选择进入哪个店铺").setEncryptData(shopList);
        }
    }

    /**
     * 多店铺用户进入商家中心
     * @param appBaseResult
     * @return
     */
    @CrossOrigin
    @PostMapping("homepage/info2")
    public AppBaseResult getShopCenterInfo2(@RequestBody AppBaseResult appBaseResult){
        HashMap data = (HashMap) appBaseResult.getData();
        int storeID=(int)data.get("storeID");
        HashMap result=shopInfoService.queryShopInfo2(storeID);
        return AppBaseResult.success().setEncryptData(result);
    }

}
