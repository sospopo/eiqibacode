package com.laiwanba.service.impl;

import com.laiwanba.dto.ActivityInfo;
import com.laiwanba.dto.EqibaResult;
import com.laiwanba.service.ActivityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chunmiao on 17-3-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-*.xml")
public class ActivityServiceImplTest {
    @Autowired
    ActivityService activityService;
    @Test
    public void getRecentActivity() throws Exception {
        EqibaResult<ActivityInfo> laiwanbaResult= activityService.getRecentActivity(0,2);
        System.out.println(laiwanbaResult);
    }

}