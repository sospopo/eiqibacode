package com.laiwanba.controller;

import com.laiwanba.dto.EqibaResult;
import com.laiwanba.entity.User;
import com.laiwanba.exception.*;
import com.laiwanba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * Created by chunmiao on 17-3-28.
 */
@RequestMapping("/user")
@Controller
public class UserController {
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
    public EqibaResult<User> loginInController(@RequestBody User user){
        ArrayList<User> result = new ArrayList<User>();
        try {
            result.add(userService.loginInService(user));
        }catch (EmptyObjectErrorException e){
            return new EqibaResult<User>(-3,e.getMessage());
        }catch (CannotFindUserException e){
            return new EqibaResult<User>(-2,e.getMessage());
        }catch (SystemErrorException e){
            return new EqibaResult<User>(-1,e.getMessage());
        }catch (ObjectCannotMatchException e){
            return new EqibaResult<User>(0,e.getMessage());
        }catch (StatusWrongException e){
            return new EqibaResult<User>(-4,e.getMessage());
        }catch (UpdateDataBaseException e){
            return new EqibaResult<User>(-5,e.getMessage());
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
