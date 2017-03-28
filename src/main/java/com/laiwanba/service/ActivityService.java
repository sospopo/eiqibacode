package com.laiwanba.service;

import com.laiwanba.dto.ActivityInfo;
import com.laiwanba.dto.EqibaResult;

/**
 * Created by chunmiao on 17-3-5.
 */
public interface ActivityService {
    public EqibaResult<ActivityInfo> getRecentActivity(int offset, int limit);
}
