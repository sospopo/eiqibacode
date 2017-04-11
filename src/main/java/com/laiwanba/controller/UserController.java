package com.laiwanba.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laiwanba.dto.EqibaResult;
import com.laiwanba.entity.User;
import com.laiwanba.exception.*;
import com.laiwanba.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by chunmiao on 17-3-28.
 */
@RequestMapping("/user")
@Controller
public class UserController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    Gson gson = new Gson();

    @Autowired
    UserService userService;
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public EqibaResult<Integer> registerController(@RequestBody User user){
        EqibaResult<Integer> result  = userService.registerService(user);

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public EqibaResult<User> loginInController(@RequestBody User user,HttpServletRequest request){
        //登录后保持登录状态
        HttpSession  session = request.getSession(false);
        ArrayList<User> result = new ArrayList<User>();
        //判断用户是否登录
        if (session != null) {
            String s = (String) session.getAttribute("user");
            User toUser = gson.fromJson(s, User.class);
            if (toUser!=null && toUser.getUserName().equals(user.getUserName())&&
                    toUser.getPassword().equals(user.getPassword())){
                result.add(toUser);
                return new EqibaResult<User>(1,result);
            }else {
                return new EqibaResult<User>(-1,"帐号或密码错误");
            }
        }

        try {
            HttpSession createSession = request.getSession();
            User res = userService.loginInService(user);
            createSession.setAttribute("user",gson.toJson(res));
            res.setPassword("");
            result.add(res);
        } catch (EmptyObjectErrorException e) {
            return new EqibaResult<User>(-3, e.getMessage());
        } catch (CannotFindUserException e) {
            return new EqibaResult<User>(-2, e.getMessage());
        } catch (SystemErrorException e) {
            return new EqibaResult<User>(-1, e.getMessage());
        } catch (ObjectCannotMatchException e) {
            return new EqibaResult<User>(0, e.getMessage());
        } catch (StatusWrongException e) {
            return new EqibaResult<User>(-4, e.getMessage());
        } catch (UpdateDataBaseException e) {
            return new EqibaResult<User>(-5, e.getMessage());
        }

        return new EqibaResult<User>(1,result);
    }

    @RequestMapping(value = "/loginOut",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public EqibaResult<Integer> loginOutService(@RequestBody User user){
        try {
            userService.loginOutService(user);
        }catch (StatusWrongException e){
            return new EqibaResult<Integer>(-1,e.getMessage());
        }catch (UpdateDataBaseException e){
            return new EqibaResult<Integer>(-2,e.getMessage());
        }

        return new EqibaResult<Integer>(1," 成功退出～！");
    }
}
