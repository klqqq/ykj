package com.ykj.java.modules.user.dao;

import com.ykj.java.modules.user.entity.UserEntity;
import com.ykj.java.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author bnz
 * @email object_bnz@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
    UserEntity queryByMobile(String mobile);
}
