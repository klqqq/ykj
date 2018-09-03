package com.ykj.java.modules.app.controller;

import com.ykj.java.common.utils.AppBaseResult;
import com.ykj.java.modules.app.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
     * 获取商家中心首页信息======================================需增加判断是否有多个店铺接口
     * @param appBaseResult
     * @return
     */
    @CrossOrigin
    @PostMapping("homepage/info")
    public AppBaseResult getGiftInfo(@RequestBody AppBaseResult appBaseResult){
        HashMap data = (HashMap) appBaseResult.getData();
        int userId=(int)data.get("userId");
        //判断是不是商家
        int check=shopInfoService.queryIdentity(userId);
        if(check<1)
            return AppBaseResult.error("抱歉，您不是商家用户");
        else {
            //获取商家首页信息
            HashMap result=shopInfoService.queryShopInfo(userId);
            return AppBaseResult.success().setEncryptData(result);
        }

    }

}
