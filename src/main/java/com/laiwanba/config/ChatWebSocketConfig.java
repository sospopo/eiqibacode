package com.laiwanba.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;


/**
 * Created by chunmiao on 17-4-4.
 */
@Configuration
@EnableWebSocketMessageBroker
public class ChatWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //设置webSocket链接请求地址(握手)
        stompEndpointRegistry.addEndpoint("/portfolio").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        //设置发送信息的地址对应@MessageMapping
        messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
        //设置/talk一对一消息对话请求前缀对应@SendToUser
        messageBrokerRegistry.setUserDestinationPrefix("/talk");
        //设置/topic为广播地址,发送给所有已建立链接的客户端,启用基于内存的代理
        messageBrokerRegistry.enableSimpleBroker("/topic","/talk");
    }
}
