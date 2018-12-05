package com.example.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author: Alexchs
 * @Description:
 *      https://www.cnblogs.com/java-zhao/p/5350021.html
 *      https://blog.csdn.net/dream_broken/article/details/72385295
 * @Date: created in 23:41 2018-12-02
 * @ModifiedBy:
 * @URL:
 */

@Configuration
//@MapperScan(basePackages = {"com.example.*.dao"})  // 可以扫描多个包，不必再用@mapper注解
@ConfigurationProperties
@PropertySource("classpath:/mybatisConfig.properties")
public class MybatisConfig {


    @Autowired
    private Environment env;

    /**
     * 创建数据源
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     */
    @Bean
    @Primary
    public DataSource getDataSource() throws Exception{
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
        props.put("url", env.getProperty("jdbc.url"));
        props.put("username", env.getProperty("jdbc.username"));
        props.put("password", env.getProperty("jdbc.password"));

        setDruidBaseProps(props);
        return DruidDataSourceFactory.createDataSource(props);
    }

    private void setDruidBaseProps(Properties props) {
        props.put("initialSize", env.getProperty("spring.datasource.druid.initial-size"));
        props.put("maxActive", env.getProperty("spring.datasource.druid.max-active"));
        props.put("minIdle", env.getProperty("spring.datasource.druid.min-idle"));
        props.put("timeBetweenEvictionRunsMillis", env.getProperty("spring.datasource.druid.time-between-eviction-runs-millis"));
//        props.put("numTestsPerEvictionRun", env.getProperty("spring.datasource.druid.time-between-eviction-runs-millis"));
        props.put("maxWait", env.getProperty("spring.datasource.druid.max-wait"));
        props.put("validationQuery", env.getProperty("spring.datasource.druid.validation-query"));
        props.put("minEvictableIdleTimeMillis", env.getProperty("spring.datasource.druid.min-evictable-idle-time-millis"));
        props.put("testWhileIdle", env.getProperty("spring.datasource.druid.test-while-idle"));
        props.put("validationQuery", env.getProperty("spring.datasource.druid.validation-query"));
        props.put("testOnBorrow", env.getProperty("spring.datasource.druid.test-on-borrow"));
        props.put("testOnReturn", env.getProperty("spring.datasource.druid.test-on-return"));
        props.put("poolPreparedStatements", env.getProperty("spring.datasource.druid.pool-prepared-statements"));
        props.put("maxOpenPreparedStatements", env.getProperty("spring.datasource.druid.max-pool-prepared-statement-per-connection-size"));
//        props.put("filters", env.getProperty("spring.datasource.druid.filters"));
        props.put("connectionProperties", env.getProperty("spring.datasource.druid.connection-properties"));
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);//指定数据源(这个必须有，否则报错)
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//指定xml文件位置

        return fb.getObject();
    }

}
