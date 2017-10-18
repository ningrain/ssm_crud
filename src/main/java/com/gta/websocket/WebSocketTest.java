package com.gta.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * WebSocket测试类
 * Created by JNN on 2017/9/28.
 */
@ServerEndpoint("/websocket")
public class WebSocketTest {

    private static int onlineCount;

    private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        onlineCount++;
        System.out.println("有新连接加入，当前在线人数为：" + onlineCount);
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        onlineCount--;
        System.out.println("有一连接关闭，当前在线人数为：" + onlineCount);
    }

    @OnMessage
    public void onMessage(String msg){
        System.out.println("来自客户端的消息：" + msg);
        for (WebSocketTest webSocketTest : webSocketSet){
            try {
                webSocketTest.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    private void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }
}
