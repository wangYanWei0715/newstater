package com.icss.starter.autoconfiguration;

import com.alibaba.druid.pool.DruidDataSource;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


/**
 * @author 王延伟
 * @description TODO
 * @createTime 2020年3月31日$ 21点24分$
 */
@Configuration
//@ConditionalOnClass({ JdbcTemplate.class, AbstractRoutingDataSource.class })
@ConditionalOnBean(DataSource.class)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
@Order
public class AutoDataSourcesConfiguration{



    /**
     * @description 有DruidDataSource数据源
     *
     * @author 王延伟
     * @createTime 2020/3/31 11:15
     * @method dataSourceOnClass
     * @param [dataSources]
     * @return javax.sql.DataSource
     */
    @Bean
    @ConditionalOnBean(DruidDataSource.class)
    public DataSource dataSourceOnClass(Map<String, DataSource> dataSources) {

        return new DruidDataSource();
    }

    /**
     * @description 没有DruidDataSource数据源
     *
     * @author 王延伟
     * @createTime 2020/3/31 11:15
     * @method dataSourceOnMissingClass
     * @return javax.sql.DataSource
     */
    @Bean
    @ConditionalOnMissingBean(DruidDataSource.class)
    public DataSource dataSourceOnMissingClass() {

        return new DruidDataSource();
    }








}
