package com.ykj.java.modules.app.service.impl;

import com.ykj.java.modules.app.dao.AppSaleGoodsDao;
import com.ykj.java.modules.app.service.AppSaleGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("appSaleGoodsService")
public class AppSaleGoodsServiceImpl implements AppSaleGoodsService {
    @Autowired
    private AppSaleGoodsDao appSaleGoodsDao;

    @Override
    public int insertSaleGoods(HashMap<String, Object> map) {

        return appSaleGoodsDao.insertSaleGoods(map);
    }
}
