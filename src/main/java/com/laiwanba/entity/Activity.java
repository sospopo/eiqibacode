package com.laiwanba.entity;

import java.util.Date;

/**
 * Created by chunmiao on 17-3-5.
 */
public class Activity {
    //活动id
    long actId;
    //活动内容
    String actContent;
    //图片地址
    String picUrl;
    //活动标题
    String actTitle;
    //活动开始时间
    Date startTime;
    //活动结束时间
    Date endTime;
    //创建者id
    long creatorId;
    //活动人数
    long actNumber;
    //活动创建日期
    Date createTime;

    public long getActId() {
        return actId;
    }

    public void setActId(long actId) {
        this.actId = actId;
    }

    public String getActContent() {
        return actContent;
    }

    public void setActContent(String actContent) {
        this.actContent = actContent;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public long getActNumber() {
        return actNumber;
    }

    public void setActNumber(long actNumber) {
        this.actNumber = actNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "actId=" + actId +
                ", actContent='" + actContent + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", actTitle='" + actTitle + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", creatorId=" + creatorId +
                ", actNumber=" + actNumber +
                ", createTime=" + createTime +
                '}';
    }
}
