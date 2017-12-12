package com.gta.singleton;

/**
 * 天气信息实体类，单例模式
 * Created by ningning.jiang on 2017/12/12.
 */
public class Weather {

    private String type;

    private String low;

    private String high;

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private static Weather weather = null;

    public static Weather getInstance() {
        if (weather == null){
            weather = new Weather();
        }
        return weather;
    }

    private Weather() {
    }
}
