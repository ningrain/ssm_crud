package com.gta.util;

/**
 * Desc: 数据源操作类
 * User: jiangningning
 * Date: 2018/2/24
 * Time: 11:02
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> THREAD_LOCAL_DATASOURCE = new ThreadLocal<>();

    /**
     *  获取当前线程的数据源路由的key
     */
    public static String getDataSource(){
        return THREAD_LOCAL_DATASOURCE.get();
    }

    /**
     *  绑定当前线程的数据源路由的key
     *  使用完成必须调用 clearDataSource() 方法删除
     */
    public static void setDataSource(String val){
        THREAD_LOCAL_DATASOURCE.set(val);
    }

    /**
     *  删除与当前线程绑定的数据源路由的key
     */
    public static void clearDataSource(){
        THREAD_LOCAL_DATASOURCE.remove();
    }
}
