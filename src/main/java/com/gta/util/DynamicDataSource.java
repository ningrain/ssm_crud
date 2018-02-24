package com.gta.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Desc: 获得数据源
 * User: jiangningning
 * Date: 2018/2/24
 * Time: 10:54
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSource();
    }
}
