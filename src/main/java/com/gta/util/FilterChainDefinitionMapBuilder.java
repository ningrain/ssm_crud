package com.gta.util;

import java.util.LinkedHashMap;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/26
 * Time: 14:53
 */
public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        // 从数据库获取权限相关信息， 此处写死
        map.put("/index.jsp", "anon");
        map.put("/resources/**", "anon");
        map.put("/demo/**", "anon");
        map.put("/login", "anon");
        map.put("/user", "authc,roles[user]");
        map.put("/admin", "authc,roles[admin]");
        map.put("/logout", "logout");
        map.put("/**", "authc");
        return map;
    }

}
