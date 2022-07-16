package com.gugu.example.gugudatasourcedemo.datasource;

import com.gugu.example.gugudatasourcedemo.holder.DBContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author gugu
 * @Classname MyRoutingDataSource
 * @Description TODO
 * @Date 2022/7/16 20:19
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
