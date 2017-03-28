package com.laiwanba.controller;

import com.laiwanba.dto.EqibaResult;
import com.laiwanba.entity.User;
import com.laiwanba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        System.out.println(user);
        EqibaResult<Integer> result  = userService.registerService(user);

        return result;
    }
}
