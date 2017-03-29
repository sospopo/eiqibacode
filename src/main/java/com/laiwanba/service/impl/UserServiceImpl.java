package com.laiwanba.service.impl;

import com.laiwanba.dao.UserDao;
import com.laiwanba.dto.EqibaResult;
import com.laiwanba.entity.User;
import com.laiwanba.exception.*;
import com.laiwanba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by chunmiao on 17-3-28.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    //注册逻辑
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

    //登录逻辑操作
    public User loginInService(User loginUser){
        if (loginUser == null){
            throw new EmptyObjectErrorException("登录失败！请检查数据是否填充！");
        }
        User comUser;
        User result;
        //从数据库获取数据
        comUser = getUserFromDataBase(loginUser);
        //查询用户密码是否正确以及用户状态是否被锁定或者在线
        if (!comUser.getPassword().equals(loginUser.getPassword())){
            throw new ObjectCannotMatchException("密码错误！");
        }else {
            if (comUser.getStatus() == -1){
                throw new StatusWrongException("用户已被锁定！无法登录！");
            }else if (comUser.getStatus() == 1){
                throw new StatusWrongException("用户已经在线！");
            }else {
                result = comUser;
                executeLoginInUpdate(comUser);
                result.setStatus(1);
                /*将返回用户数据的密码清空*/
                result.setPassword("");
            }
        }
        return result;
    }

    //执行登出操作
    @Override
    public int loginOutService(User loginOutUser) throws StatusWrongException,
            UpdateDataBaseException{
        User comUser = getUserFromDataBase(loginOutUser);
        if(comUser.getStatus() == 0){
            throw new StatusWrongException("用户已经退出！");
        }else if (comUser.getStatus() == -1){
            throw new StatusWrongException("用户已经被锁定！");
        }else {
            executeLoginOutUpdate(loginOutUser);
        }
        return 1;
    }
    //更新登出状态
    private void executeLoginOutUpdate(User loginOutUser) {
        User user = new User();
        user.setLoginOutTime(new Date());
        user.setUserId(loginOutUser.getUserId());
        user.setStatus(0);
        try {
            userDao.updateUserLoginTime(user);
        }catch (Exception e){
            throw new UpdateDataBaseException("更新登出操作失败！请重新登出！");
        }
    }


    //登录操作，更新数据库
    private void executeLoginInUpdate(User comUser) {
        User user = new User();
        user.setStatus(1);
        user.setUserId(comUser.getUserId());
        user.setLoginInTime(new Date());
        try {
            userDao.updateUserLoginTime(user);
        }catch (Exception e){
            throw new UpdateDataBaseException("更新登录状态失败！请重新登录！");
        }
    }

    //通过user信息来比对数据库里面的信息
    private User getUserFromDataBase(User loginUser) {
        User result;
        try {
            if (loginUser.getUserId() != 0){
                result = userDao.getUserByType(loginUser.getUserId(), null, null, 0);
            } else if (loginUser.getUserName() != null) {
                result = userDao.getUserByType(0, loginUser.getUserName(), null, 0);
            } else if (loginUser.getUserEmail() != null) {
                result = userDao.getUserByType(0, null, loginUser.getUserEmail(), 0);
            } else if (loginUser.getUserPhone() != null) {
                result = userDao.getUserByType(0, null, null, loginUser.getUserPhone());
            } else {
                throw new CannotFindUserException("登录失败！请输入正确用户名或手机号或邮箱来进行登录！");
            }

            if (result == null){
                throw new CannotFindUserException("登录失败！请输入正确用户名或手机号或邮箱来进行登录！");
            }
        }catch (SystemErrorException e){
            throw new SystemErrorException("登录失败！请输入用户名或手机号或邮箱来进行登录！",e);
        }
        return result;
    }
}
