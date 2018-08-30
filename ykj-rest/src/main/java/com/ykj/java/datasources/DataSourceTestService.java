package com.ykj.java.datasources;

import com.ykj.java.datasources.annotation.DataSource;
import com.ykj.java.modules.user.entity.UserEntity;
import com.ykj.java.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试
 * @author bnz
 * @email object_bnz@163.com
 * @date 2017/9/16 23:10
 */
@Service
public class DataSourceTestService implements DataSourceTestInterface{

    @Autowired
    private UserService userService;

    @Override
    public UserEntity queryObject(Long userId){
        return userService.queryObject(userId);
    }

    @DataSource(name = DataSourceNames.SECOND)
    @Override
    public UserEntity queryObject2(Long userId){
        return userService.queryObject(userId);
    }
}
