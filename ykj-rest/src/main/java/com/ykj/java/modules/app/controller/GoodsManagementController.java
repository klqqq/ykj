package com.ykj.java.modules.app.controller;

import com.ykj.java.common.utils.AppBaseResult;
import com.ykj.java.modules.app.service.GoodsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:   yrx
 * Date:     2018/9/4 15:51
 * 商品管理
 **/
@RestController
@RequestMapping("/api/shopGoods")
public class GoodsManagementController {

    @Autowired
    private GoodsCustomService goodsCustomService;

    /**
     * 获取商品管理的分类信息
     * @param appBaseResult
     * @return
     */
    @CrossOrigin
    @PostMapping("custom/kinds")
    public AppBaseResult getGoodsCustomKinds(@RequestBody AppBaseResult appBaseResult){
        HashMap data = (HashMap) appBaseResult.getData();
        int shop_id=(int)data.get("shop_id");
        List<HashMap<String,Object>> list=goodsCustomService.queryCustomList(shop_id);
        Map result=new HashMap<>();
        result.put("kinds",list);
        return AppBaseResult.success().setEncryptData(result);
    }

    /**
     * 重命名分类
     */
    @CrossOrigin
    @PostMapping("custom/kinds/rename")
    public AppBaseResult getShopCenterInfo1(@RequestBody AppBaseResult appBaseResult){
        HashMap data = (HashMap) appBaseResult.getData();
        int productTypeID=(int)data.get("productTypeID");
        String newName=data.get("newName").toString();
        goodsCustomService.updateKindsName(productTypeID,newName);
        return AppBaseResult.success();
    }

    /**
     * 置顶分类
     */

    /**
     * 删除分类
     */

    /**
     * 新增分类
     */
}
