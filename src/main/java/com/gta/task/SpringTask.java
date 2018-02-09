package com.gta.task;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gta.singleton.Weather;
import com.gta.util.WeatherAPI;
import com.gta.websocket.WebSocketTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/12/7
 * Time: 17:07
 */
@Component
public class SpringTask {

    //@PostConstruct
    public void init(){
        getWeatherType();
    }

    //@Scheduled(cron = "0/5 * * * * ?")
    public void taskJobTest(){
        WebSocketTest webSocketTest = new WebSocketTest();
        webSocketTest.onMessage("5秒发送一次");
        System.out.println("AAAAAAAAAAAAAAAAAA");
    }

    @Scheduled(cron = "0 0 20 * * ? ")
    public void getWeatherType(){

        String weatherWithJson = WeatherAPI.getWeatherWithJson("合肥");
        String s1 = (String) WeatherAPI.getValue(weatherWithJson, "data");
        String s2 = (String) WeatherAPI.getValue(s1, "forecast");
        JSONArray jsonArray = JSONObject.parseArray(s2);
        String type = (String) WeatherAPI.getValue(jsonArray.get(0).toString(), "type");
        String low = (String) WeatherAPI.getValue(jsonArray.get(0).toString(), "low");
        String high = (String) WeatherAPI.getValue(jsonArray.get(0).toString(), "high");
        Weather weather = Weather.getInstance();
        weather.setType(type);
        weather.setLow(low);
        weather.setHigh(high);
    }

}
