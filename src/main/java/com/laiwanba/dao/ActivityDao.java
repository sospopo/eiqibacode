package com.laiwanba.dao;

import com.laiwanba.entity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chunmiao on 17-3-5.
 */
public interface ActivityDao {
    //获取所有activitys
    public List<Activity> getActivityList(@Param("offset") int offset,@Param("limit") int limit);

    //添加活动
    public int addActivity(Activity activity);
}
