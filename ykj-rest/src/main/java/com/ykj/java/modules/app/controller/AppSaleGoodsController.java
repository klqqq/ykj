package com.ykj.java.modules.app.controller.appUpdate.controller;

import com.ykj.java.common.exception.YkjException;
import com.ykj.java.common.utils.AppBaseResult;
import com.ykj.java.modules.app.service.AppSaleGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;

@RestController
@RequestMapping("api/")
public class AppSaleGoodsController {

    @Autowired
    private AppSaleGoodsService appSaleGoodsService;

    @CrossOrigin
    @PostMapping("addSaleGoods")
    public AppBaseResult addSaleGoods(@RequestBody AppBaseResult appBaseResult){
        HashMap<String,Object> data=(HashMap) appBaseResult.getData();
        int i=appSaleGoodsService.insertSaleGoods(data);
        if( i <= 0){
            throw new YkjException("新增失败");
        }
        return AppBaseResult.success("新增成功");
    }






}
