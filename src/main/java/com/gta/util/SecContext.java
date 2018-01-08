package com.gta.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/1/3
 * Time: 11:43
 */
public class SecContext {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(SecContext.class);

    private static SecContext instance;
    private static Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();

    private SecContext() {
    }

    public static SecContext getInstance() {
        if (instance == null) {
            instance = new SecContext();
        }
        return instance;
    }

    public synchronized void addSession(String id, HttpSession newSession) {
        if ((id == null || "".equals(id)) || newSession == null) {
            return;
        }
        sessionMap.remove(id);
        sessionMap.put(id, newSession);
        LOGGER.debug("student["+id+"] is saved for integralTask...");
    }

    public synchronized void delSession(String id) {
        if (id == null || "".equals(id)) {
            return;
        }
        sessionMap.remove(id);
        LOGGER.debug("student["+id+"] is delete for integralTask...");
    }

    public synchronized HttpSession getSession(String id) {
        if (id == null || "".equals(id)) {
            return null;
        }
        return sessionMap.get(id);
    }

    public static Map<String, HttpSession> getSessionMap() {
        return sessionMap;
    }
}
