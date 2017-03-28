package com.laiwanba.service.impl;

import com.laiwanba.entity.User;
import com.laiwanba.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chunmiao on 17-3-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    public void registerService() throws Exception {
        User user = new User();
        user.setUserName("Lily");
        user.setPassword("844934");
        user.setUserPhone(4344444L);
        user.setUserEmail("Liluy@qq.com");
        user.setUserSex("women");
        user.setUserAge(18);
        user.setUserPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490693077216&di=26e17de44ece0c5a26f981369a87034b&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3Df0c5c08030d3d539c16807c70fb7c566%2F8ad4b31c8701a18bbef9f231982f07082838feba.jpg");
        System.out.println(userService.registerService(user));
    }

}