package com.callor.jc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.callor.jc.repository")
@PropertySource("classpath:db.properties")
public class MyBatisConfig {

    @Value("${db.driver}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;


    private final StandardPBEStringEncryptor encryptor;
    public MyBatisConfig(StandardPBEStringEncryptor encryptor) {
        this.encryptor = encryptor;
    }
    // dataSource
    private DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        String planUsername
                = encryptor.decrypt(username);
        String planPassword
                = encryptor.decrypt(password);
        ds.setUsername(planUsername);
        ds.setPassword(planPassword);
        return ds;
    }

    // SqlSessionFactory
    // 여기는 반드시 시스템에서 사용할수 있도록 Bean 으로 설정한다
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean sqlBean = new SqlSessionFactoryBean();
        sqlBean.setDataSource(this.getDataSource());
        sqlBean.setTypeAliasesPackage("com.callor.jc.models");
        return sqlBean;
    }

    // SqlSessionTemplate
    // 여기도 반드시 Bean 으로 등록한다.
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
        SqlSessionTemplate sqlSessionTemplate
                = new SqlSessionTemplate(factory);
        return sqlSessionTemplate;
    }

}
