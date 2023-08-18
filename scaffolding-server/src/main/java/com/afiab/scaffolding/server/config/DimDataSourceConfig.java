package com.afiab.scaffolding.server.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 13:21
 * @Description: 维表数据源配置
 */
@Configuration
@MapperScan(basePackages = "com.afiab.scaffolding.dao.mapper.dim" ,sqlSessionTemplateRef = "dimSqlSessionTemplate" )
public class DimDataSourceConfig {
    @Value("${spring.datasource.type}")
    private String type ;
    @Value("${spring.datasource.druid.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.dim.druid.url}")
    private String url;
    @Value("${spring.datasource.dim.druid.username}")
    private String userName;
    @Value("${spring.datasource.dim.druid.password}")
    private String password;
    @Value("${spring.datasource.dim.druid.filters}")
    private String filters ;
    @Value("${spring.datasource.dim.druid.maxActive}")
    private Integer maxActive;
    @Value("${spring.datasource.dim.druid.initialSize}")
    private Integer initialSize;
    @Value("${spring.datasource.dim.druid.maxWait}")
    private long maxWait;
    @Value("${spring.datasource.dim.druid.minIdle}")
    private Integer minIdle;
    @Value("${spring.datasource.dim.druid.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.dim.druid.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${spring.datasource.dim.druid.maxEvictableIdleTimeMillis}")
    private long maxEvictableIdleTimeMillis;
//    @Value("${spring.datasource.dim.druid.phy-timeout-millis}")
//    private long phyTimeoutMillis;
    @Value("${spring.datasource.dim.druid.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${spring.datasource.dim.druid.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${spring.datasource.dim.druid.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${spring.datasource.dim.druid.poolPreparedStatements}")
    private Boolean poolPreparedStatements;
    @Value("${spring.datasource.dim.druid.maxOpenPreparedStatements}")
    private int maxOpenPreparedStatements;
    @Value("${spring.datasource.dim.druid.validationQuery}")
    private String validationQuery;

    @Bean(name = "dimDataSource")
    public DataSource platformDataSource() throws Exception{
        Class classes = Class.forName(type);
        String druidName = "mysql_系统默认_dim_2";
        DruidDataSource dataSource = (DruidDataSource) DataSourceBuilder
                .create()
                .driverClassName(driverClassName)
                .type(classes)
                .url(url)
                .username(userName)
                .password(password)
                .build();
        dataSource.setName(druidName);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);
//        dataSource.setPhyTimeoutMillis(phyTimeoutMillis);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        dataSource.setFilters(filters);
        return dataSource;
    }

    @Bean(name = "dimSqlSessionFactory")
    public SqlSessionFactory platformSqlSessionFactory(@Qualifier("dimDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/dim/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "dimDataSourceTransactionManager")
    public DataSourceTransactionManager platformDataSourceTransactionManager(@Qualifier("dimDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dimSqlSessionTemplate")
    public SqlSessionTemplate platformSqlSessionTemplate(@Qualifier("dimSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
