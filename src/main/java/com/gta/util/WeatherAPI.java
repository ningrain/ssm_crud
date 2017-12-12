package com.gta.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * Desc: 获取城市天气接口
 * User: jiangningning
 * Date: 2017/12/11
 * Time: 9:36
 * eg:
 *   json格式: http://www.sojson.com/open/api/weather/json.shtml?city=北京
 *   xml格式:  http://www.sojson.com/open/api/weather/xml.shtml?city=北京
 */
public class WeatherAPI {

    private static RestTemplate restTemplate = new RestTemplate();

    /**
     * 方法 getWeatherWithJson 功能： 获取某城市json格式天气
     * @param cityName 城市中文名称
     * @return java.lang.String
     * @author ningning.jiang 2017年12月12日 11:33:28
     */
    public static String getWeatherWithJson(String cityName){
        try {
            cityName = URLDecoder.decode(cityName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String apiUrlJson = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s", cityName);
        String stringObject = restTemplate.getForObject(apiUrlJson, String.class, cityName);
        System.out.println(stringObject);
        return stringObject;
    }

    /**
     * 方法 getWeatherWithXml 功能： 获取某城市xml格式天气
     * @param cityName 城市中文名称
     * @return java.lang.String
     * @author ningning.jiang 2017年12月12日 11:34:17
     */
    public static String getWeatherWithXml(String cityName){
        try {
            cityName = URLDecoder.decode(cityName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String apiUrlXml = String.format("http://www.sojson.com/open/api/weather/xml.shtml?city=%s", cityName);
        String stringObject = restTemplate.getForObject(apiUrlXml, String.class, cityName);
        System.out.println(stringObject);
        return stringObject;
    }

    /**
     * 方法 getWeather 功能： 获取天气信息
     * @param cityName 城市中文名
     * @param type 天气格式，可用参数取值：xml, json
     * @return java.lang.String
     * @author ningning.jiang 2017年12月12日 11:40:02
     */
    public static String getWeather(String cityName, String type){
        try {
            cityName = URLDecoder.decode(cityName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "http://www.sojson.com/open/api/weather/".concat(type).concat(".shtml?city=%s");
        url = String.format(url, cityName);
        String result = restTemplate.getForObject(url, String.class, cityName);
        System.out.println(result);
        return result;
    }

    public static Object getValue(String str, String key) {
        // 将字符串转换成json对象
        JSONObject jsonObject = JSONObject.parseObject(str);
        // 获取迭代器
        Set<Map.Entry<String, Object>> ite = jsonObject.entrySet();
        Object result = "";
        // 遍历jsonObject对象中的数据,将数据添加到jsonToMap对象
        for (Map.Entry<String, Object> anIte : ite) {
            if (key != null && !"".equals(key)){
                if (key.equals(anIte.getKey())){
                    result = jsonObject.get(key).toString();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = (String) WeatherAPI.getValue("{\n" +
                "    \"date\": \"20171212\",\n" +
                "    \"message\": \"Success !\",\n" +
                "    \"status\": 200,\n" +
                "    \"city\": \"北京\",\n" +
                "    \"count\": 541,\n" +
                "    \"data\": {\n" +
                "        \"shidu\": \"21%\",\n" +
                "        \"pm25\": 5,\n" +
                "        \"pm10\": 17,\n" +
                "        \"quality\": \"优\",\n" +
                "        \"wendu\": \"-5\",\n" +
                "        \"ganmao\": \"各类人群可自由活动\",\n" +
                "        \"yesterday\": {\n" +
                "            \"date\": \"11日星期一\",\n" +
                "            \"sunrise\": \"07:25\",\n" +
                "            \"high\": \"高温 2.0℃\",\n" +
                "            \"low\": \"低温 -8.0℃\",\n" +
                "            \"sunset\": \"16:49\",\n" +
                "            \"aqi\": 30,\n" +
                "            \"fx\": \"北风\",\n" +
                "            \"fl\": \"3-4级\",\n" +
                "            \"type\": \"晴\",\n" +
                "            \"notice\": \"lovely sunshine，尽情享受阳光的温暖吧\"\n" +
                "        },\n" +
                "        \"forecast\": [\n" +
                "            {\n" +
                "                \"date\": \"12日星期二\",\n" +
                "                \"sunrise\": \"07:26\",\n" +
                "                \"high\": \"高温 -1.0℃\",\n" +
                "                \"low\": \"低温 -8.0℃\",\n" +
                "                \"sunset\": \"16:50\",\n" +
                "                \"aqi\": 64,\n" +
                "                \"fx\": \"东北风\",\n" +
                "                \"fl\": \"<3级\",\n" +
                "                \"type\": \"多云\",\n" +
                "                \"notice\": \"悠悠的云里有淡淡的诗\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"13日星期三\",\n" +
                "                \"sunrise\": \"07:26\",\n" +
                "                \"high\": \"高温 1.0℃\",\n" +
                "                \"low\": \"低温 -7.0℃\",\n" +
                "                \"sunset\": \"16:50\",\n" +
                "                \"aqi\": 77,\n" +
                "                \"fx\": \"东北风\",\n" +
                "                \"fl\": \"<3级\",\n" +
                "                \"type\": \"晴\",\n" +
                "                \"notice\": \"lovely sunshine，尽情享受阳光的温暖吧\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"14日星期四\",\n" +
                "                \"sunrise\": \"07:27\",\n" +
                "                \"high\": \"高温 -1.0℃\",\n" +
                "                \"low\": \"低温 -5.0℃\",\n" +
                "                \"sunset\": \"16:50\",\n" +
                "                \"aqi\": 97,\n" +
                "                \"fx\": \"西南风\",\n" +
                "                \"fl\": \"<3级\",\n" +
                "                \"type\": \"阴\",\n" +
                "                \"notice\": \"阴天是彩虹的前期之景\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"15日星期五\",\n" +
                "                \"sunrise\": \"07:28\",\n" +
                "                \"high\": \"高温 4.0℃\",\n" +
                "                \"low\": \"低温 -5.0℃\",\n" +
                "                \"sunset\": \"16:50\",\n" +
                "                \"aqi\": 106,\n" +
                "                \"fx\": \"北风\",\n" +
                "                \"fl\": \"3-4级\",\n" +
                "                \"type\": \"多云\",\n" +
                "                \"notice\": \"悠悠的云里有淡淡的诗\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"16日星期六\",\n" +
                "                \"sunrise\": \"07:29\",\n" +
                "                \"high\": \"高温 2.0℃\",\n" +
                "                \"low\": \"低温 -6.0℃\",\n" +
                "                \"sunset\": \"16:50\",\n" +
                "                \"aqi\": 33,\n" +
                "                \"fx\": \"西北风\",\n" +
                "                \"fl\": \"3-4级\",\n" +
                "                \"type\": \"晴\",\n" +
                "                \"notice\": \"lovely sunshine，尽情享受阳光的温暖吧\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}", "data");
        String s = (String) WeatherAPI.getValue(str, "forecast");
        JSONArray jsonArray = JSONObject.parseArray(s);
        System.out.println(jsonArray.get(0).toString());
        String type = (String) WeatherAPI.getValue(jsonArray.get(0).toString(), "type");
        System.out.println(type);
    }
}
