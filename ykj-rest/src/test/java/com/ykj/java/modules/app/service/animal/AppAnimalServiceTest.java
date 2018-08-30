package com.ykj.java.modules.app.service.animal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppAnimalServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppAnimalService appAnimalService;

    @Autowired
    private AppMemberDao appMemberDao;

    @Test
    public void test(){

        List<String> list = appAnimalService.queryAllPName(0);
        logger.info("list = {}", list);
    }

    @Test
    public void test1(){
        List<String> list = appAnimalService.queryAllCName("狗");
        logger.info("list = {}", list);
    }

    @Test
    public void findcname(){
        List<String> list = appAnimalService.queryAllPName(0);
        Map<String, Object> map = new HashMap<>();
        for(String pname : list){
            List<String> cname = appAnimalService.queryAllCName(pname);
            map.put(pname, cname);
        }
        logger.info("list = {}", map);
    }

    @Test
    public void member(){
        List<HashMap<String, Object>> querylist = appMemberDao.querylist();
        logger.info("list = {}", querylist);
    }

}