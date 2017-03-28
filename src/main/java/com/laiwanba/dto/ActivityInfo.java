package com.laiwanba.dto;

import com.laiwanba.entity.Activity;

/**
 * Created by chunmiao on 17-3-5.
 */
public class ActivityInfo {
    private Activity activity;

    private String userName;

    public ActivityInfo(Activity activity, String userName) {
        this.activity = activity;
        this.userName = userName;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ActivityInfo{" +
                "activity=" + activity +
                ", userName='" + userName + '\'' +
                '}';
    }
}
