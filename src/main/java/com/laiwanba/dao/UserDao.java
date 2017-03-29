package com.laiwanba.dao;

import com.laiwanba.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by chunmiao on 17-3-5.
 */
public interface UserDao {
    //通过userId获取用户信息
    public User getUserByType(@Param("userId") long userId ,
                              @Param("userName") String userName,
                              @Param("userEmail") String userEmail,
                              @Param("userPhone") long userPhone);
    //注册
    public int registerNewUser(@Param("user") User user);

    //更新用户登录时间
    public int updateUserLoginTime(@Param("user")User user);
}
