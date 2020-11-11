package com.allen.domain.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @date 2020/10/23
 */

@Configuration
@MapperScan(basePackages = {"com.allen.domain.dao"})
public class MybatisDbConfig {

    @Resource(name = "allenDs")
    private DataSource ds;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        org.springframework.core.io.Resource[] resources = resolver.getResources("classpath:mapper/*.xml");
//        bean.setMapperLocations(resources);
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

}
