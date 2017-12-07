package com.gta.task;

import com.gta.websocket.WebSocketTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/12/7
 * Time: 17:07
 */
@Component
public class SpringTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void taskJobTest(){
        WebSocketTest webSocketTest = new WebSocketTest();
        webSocketTest.onMessage("5秒发送一次");
        System.out.println("AAAAAAAAAAAAAAAAAA");
    }

}
