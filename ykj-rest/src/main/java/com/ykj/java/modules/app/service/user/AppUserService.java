package com.ykj.java.modules.app.service.user;

import com.ykj.java.common.validator.Assert;
import com.ykj.java.modules.app.service.ServiceSupport;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bnz on 2018/1/5.
 */

@Service("appUserService")
public class AppUserService extends ServiceSupport {

    /**
     * 根据手机号查询用户
     * @return
     * @throws Exception
     */
    public HashMap<String,Object> queryByMobile(HashMap<String,Object> param) throws Exception {
        String username = param.get("username").toString();
        //String password = param.get("password").toString();
        HashMap<String,Object> user = findForObject("app.AppUserDao.queryByMobile", username);
        Assert.isNull(user, "用户不存在");

        //密码错误
//        String userpassword = DigestUtils.sha256Hex(password);
//        if(!user.get("password").equals(userpassword)){
//            throw new Exception("密码错误");
//        }
        return user;
    }

    /**
     * 注册用户
     * @throws Exception
     */
    public void save(HashMap<String,Object> param) throws Exception {
        String password = param.get("password").toString();
        param.put("password",DigestUtils.sha256Hex(password).substring(0,31));
//        param.put("createTime",new Date());
        insert("api.AppUserDao.save",param);
    }


    /**
     *  查询用户
     */
    public List<HashMap<String,Object>> queryList(HashMap<String,Object> param) throws Exception{
        return findForList("app.AppUserDao.queryList",param);
    }

}
