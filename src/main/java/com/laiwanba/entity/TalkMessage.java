package com.laiwanba.entity;

import java.util.Date;

/**
 * Created by chunmiao on 17-4-2.
 */
public class TalkMessage {
    long id;
    String fromUser;
    String toUser;
    String content;
    Date sendTime;

    public TalkMessage(){

    }

    public TalkMessage(String content) {
        this.content = content;
    }

    public TalkMessage(long id, String fromUser, String toUser, String content, Date sendTime) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.sendTime = sendTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser)  {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "TalkMessage{" +
                "id=" + id +
                ", fromUser='" + fromUser + '\'' +
                ", toUser='" + toUser + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
