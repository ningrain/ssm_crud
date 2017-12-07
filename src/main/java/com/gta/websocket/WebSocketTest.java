package com.gta.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * WebSocket测试类
 * Created by JNN on 2017/9/28.
 * 注解@ServerEndpoint是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/websocket")
public class WebSocketTest {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 方法 onOpen 功能： 连接建立成功调用的方法
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @author ningning.jiang 2017年12月07日 16:55:52
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        onlineCount++;
        System.out.println("有新连接加入，当前在线人数为：" + onlineCount);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        onlineCount--;
        System.out.println("有一连接关闭，当前在线人数为：" + onlineCount);
    }

    /**
     * 方法 onMessage 功能： 收到客户端消息后调用的方法
     * @param msg 客户端发送过来的消息
     * @author ningning.jiang 2017年12月07日 16:57:26
     */
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
