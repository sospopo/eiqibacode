package com.laiwanba.service.impl;

import com.laiwanba.dao.UserDao;
import com.laiwanba.dto.EqibaResult;
import com.laiwanba.entity.User;
import com.laiwanba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chunmiao on 17-3-28.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public EqibaResult<Integer> registerService(User user) {
        int result = userDao.registerNewUser(user);
        if (result == 0){
            return new EqibaResult<Integer>(0,"重复注册!请检查电话，邮箱，用户名是否重复！");
        }else if (result < 0 ){
            return new EqibaResult<Integer>(-1,"数据库出错!");
        }else {
            return new EqibaResult<Integer>(1,"成功注册！");
        }
    }
}
