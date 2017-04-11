package com.laiwanba.controller;

import com.laiwanba.entity.TalkMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by chunmiao on 17-4-4.
 */
@Controller
public class TalkWebSocketController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    //广播发送消息
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public TalkMessage sendAll(TalkMessage message){
        TalkMessage talkMessage = new TalkMessage();
        talkMessage.setId(1234L);
        talkMessage.setContent(message.getContent());
        talkMessage.setFromUser("nima");
        talkMessage.setToUser("wo");
        talkMessage.setSendTime(new Date());
        return talkMessage;
    }

    //一对一请求控制器
    @MessageMapping("/message")
    @SendToUser("/talk/message")
    public void sendToUser(TalkMessage message){
        String toUser = message.getToUser();
        messagingTemplate.convertAndSendToUser(toUser,"/message",message);
    }

    @SubscribeMapping("/marco")
    public TalkMessage marco(){
        System.out.println("marco");
        TalkMessage message = new TalkMessage("初始化成功");
        return message;
    }

    //用http请求来发送消息
    @RequestMapping(value = "/test/sendMessage",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public TalkMessage send(@RequestBody TalkMessage message){
        String toUser = message.getToUser();
        System.out.println(message);
        messagingTemplate.convertAndSendToUser(toUser,"/message",message);
        return new TalkMessage("成功创建！");
    }
}
