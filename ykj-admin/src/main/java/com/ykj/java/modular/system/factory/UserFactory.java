package com.ykj.java.modular.system.factory;

import com.ykj.java.modular.system.transfer.UserDto;
import com.ykj.java.modular.system.model.User;
import org.springframework.beans.BeanUtils;

/**
 * 用户创建工厂
 *
 * @author ykj
 * @date 2018-05-05 22:43
 */
public class UserFactory {

    public static User createUser(UserDto userDto){
        if(userDto == null){
            return null;
        }else{
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            return user;
        }
    }
}
