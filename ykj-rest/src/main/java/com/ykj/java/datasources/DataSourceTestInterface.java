package com.ykj.java.datasources;

import com.ykj.java.modules.user.entity.UserEntity;

/**
 * Created by bnz on 2018/3/15.
 */
public interface DataSourceTestInterface {

    UserEntity queryObject(Long userId);

    UserEntity queryObject2(Long userId);
}
