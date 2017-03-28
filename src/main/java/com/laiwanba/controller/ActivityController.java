package com.laiwanba.controller;

import com.laiwanba.dto.ActivityInfo;
import com.laiwanba.dto.EqibaResult;
import com.laiwanba.exception.SystemErrorException;
import com.laiwanba.service.ActivityService;
import com.laiwanba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chunmiao on 17-3-5.
 */
@RequestMapping("/activity")
@Controller
public class ActivityController {
    @Autowired
    ActivityService activityService;
    @Autowired
    UserService userService;

    @RequestMapping("/{userId}/{offset}/{limit}/current_activity")
    @ResponseBody
    public EqibaResult<ActivityInfo> getCurrentActivities(@PathVariable("userId") long userId,
                                                          @PathVariable("offset") int offset,
                                                          @PathVariable("limit") int limit){
        try {
            EqibaResult<ActivityInfo> result = activityService.getRecentActivity(offset, limit);
            return result;
        }catch (SystemErrorException e){
            return new EqibaResult<ActivityInfo>(-1,e.getMessage());
        }
    }
}
