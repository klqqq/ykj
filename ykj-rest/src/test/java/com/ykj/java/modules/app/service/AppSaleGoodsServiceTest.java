package com.ykj.java.modules.app.service;

import com.ykj.java.modules.app.dao.AppSaleGoodsDao;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppSaleGoodsServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AppSaleGoodsService appSaleGoodsService;


    @Test
    public void insertSaleGoods() {
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("storeID",1);
        map.put("state",0);
        map.put("productType",1);
        map.put("mainPicture",1);
        map.put("productName","洗面奶");
        map.put("preferentialPrice",29.90);
        map.put("originalPrice",39.90);
        map.put("ShareCommission",0.01);
        map.put("limitNum",2);
        map.put("recevieNum",20);
        map.put("expirationDays",30);

//        String str="2018-05-20 10:50:01";
        map.put("startTime", new Date());
        map.put("endTime","2018-09-20 10:50:01");
        map.put("useTimeType",1);
        map.put("reservationType",2);
        if ((int) map.get("reservationType") == 4) {
            map.put("reservationInfo", "芙丽芳丝氨基酸洗面奶");
            map.put("detail", "芙丽芳丝氨基酸洗面奶是一款亲肤温和的洗面奶...");
        }
        int i=appSaleGoodsService.insertSaleGoods(map);
        System.out.println("i的值是："+i);
    }
}