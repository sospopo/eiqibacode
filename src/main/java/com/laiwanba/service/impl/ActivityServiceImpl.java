package com.laiwanba.service.impl;

import com.laiwanba.dao.ActivityDao;
import com.laiwanba.dao.UserDao;
import com.laiwanba.dto.ActivityInfo;
import com.laiwanba.dto.EqibaResult;
import com.laiwanba.entity.Activity;
import com.laiwanba.entity.User;
import com.laiwanba.exception.SystemErrorException;
import com.laiwanba.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chunmiao on 17-3-5.
 */
@Service
public class ActivityServiceImpl implements ActivityService{
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private UserDao userDao;
    @Override
    public EqibaResult<ActivityInfo> getRecentActivity(int offset, int limit) {
        if((offset < 0 || limit < 0 || offset > limit)){
            return new EqibaResult<ActivityInfo>(0,"查询数据错误！请检查数据！");
        }

        try {
            List<Activity> activityList = activityDao.getActivityList(offset,limit);
            List<ActivityInfo> activityInfoList = getActivityResult(activityList);
            return new EqibaResult<ActivityInfo>(1,activityInfoList);
        }catch (Exception e){
            throw new SystemErrorException("系统内部出错！" + e.getMessage());
        }
    }

    //组装返回列表结果
    private List<ActivityInfo> getActivityResult(List<Activity> activityList){
        List<ActivityInfo> activityInfoList = new ArrayList<ActivityInfo>();
        try {
            for (Activity activity : activityList) {
                User user = userDao.getUserByType(activity.getCreatorId(),null,null,0);
                String userName = user.getUserName();
                ActivityInfo activityInfo = new ActivityInfo(activity, userName);
                activityInfoList.add(activityInfo);
            }
        }catch (Exception e){
            throw e;
        }
        return activityInfoList;
    }
}
