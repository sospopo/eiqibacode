package com.laiwanba.dao;

import com.laiwanba.entity.Activity;
import com.laiwanba.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by chunmiao on 17-3-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class DaoTest {
    @Autowired
    ActivityDao activityDao;

    @Autowired
    UserDao userDao;
    @Test
    public void testReturnList() throws Exception {
        int offset = 0;
        int limit = 2;
        long userId;
        User user;
        List<Activity> activityList = activityDao.getActivityList(offset,limit);
        for(Activity activity : activityList){
            userId = activity.getCreatorId();
            user = userDao.getUserById(userId);
            System.out.println(user);
            System.out.println(activity);
        }


    }

    @Test
    public void testRegisterNewUser(){
        User user = new User();
        user.setUserName("miao");
        user.setPassword("844934");
        user.setUserPhone(180405365L);
        user.setUserEmail("844934702@qq.com");
        user.setUserSex("man");
        user.setUserAge(18);
        user.setUserPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490686889787&di=047d15400622c7a80a1db6295914e96b&imgtype=0&src=http%3A%2F%2Fimg001.photo.21cn.com%2Fphotos%2Falbum%2F20121019%2Fm600%2F098ACDE8DE08C2F25F53ACBC6187ECF4.jpg");
        if (userDao.registerNewUser(user) <= 0){
            System.out.println("failed!");
        }else {
            System.out.println("success!");
        }
    }

}