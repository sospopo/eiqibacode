package com.laiwanba.talk;

import com.laiwanba.entity.TalkMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chunmiao on 17-4-4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-*.xml")
public class TalkTest {
    private int port = 8080;
    private SockJsClient sockJsClient;
    private WebSocketStompClient stompClient;
    private final WebSocketHttpHeaders httpHeaders = new WebSocketHttpHeaders();
    @Before
    public void init() {
        List<Transport> transports = new ArrayList<Transport>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        this.sockJsClient = new SockJsClient(transports);
        this.stompClient = new WebSocketStompClient(sockJsClient);
        this.stompClient.setMessageConverter(new MappingJackson2MessageConverter());
    }

    @Test
    public void testT(){
        StompSessionHandler handler = new StompSessionHandler() {
            @Override
            public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
                stompSession.subscribe("/topic/getResponse", new StompFrameHandler() {
                    @Override
                    public Type getPayloadType(StompHeaders stompHeaders) {
                        return TalkMessage.class;
                    }

                    @Override
                    public void handleFrame(StompHeaders stompHeaders, Object o) {
                        TalkMessage talkMessage = (TalkMessage) o;
                        System.out.println(talkMessage);

                    }
                });

                try {
                    TalkMessage talkMessage = new TalkMessage();
                    talkMessage.setContent("das");
                    stompSession.send("/app/welcome",talkMessage);
                }catch (Exception e){

                }
            }

            @Override
            public void handleException(StompSession stompSession, StompCommand stompCommand, StompHeaders stompHeaders, byte[] bytes, Throwable throwable) {

            }

            @Override
            public void handleTransportError(StompSession stompSession, Throwable throwable) {

            }

            @Override
            public Type getPayloadType(StompHeaders stompHeaders) {
                return TalkMessage.class;
            }

            @Override
            public void handleFrame(StompHeaders stompHeaders, Object o) {

            }
        };

        stompClient.connect("ws://127.0.0.1:8080/portfolio",handler,httpHeaders);
    }

}
