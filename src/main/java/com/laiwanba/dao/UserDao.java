package com.laiwanba.dao;

import com.laiwanba.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by chunmiao on 17-3-5.
 */
public interface UserDao {
    //通过userId获取用户信息
    public User getUserById(@Param("userId") long userId);
    //注册
    public int registerNewUser(@Param("user") User user);
}
