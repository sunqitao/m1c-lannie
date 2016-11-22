package cn.m1c.frame.component;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 2016年11月19日  读写分离，多数据源
 * @author  phil(s@m1c.cn,m1c softCo.,ltd)
 * @version lannie
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSouce();
    }
    
}


