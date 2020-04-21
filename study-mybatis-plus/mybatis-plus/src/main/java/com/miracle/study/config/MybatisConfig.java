package com.miracle.study.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Miracle
 * @date 2020/4/21 11:45
 */
@Configuration
//开启事务支持,然后在访问数据库的Service方法上添加注解@Transactional便可
@EnableTransactionManagement(proxyTargetClass = true)
//Mapper类包扫描
@MapperScan(basePackages = "com.miracle.study.dao")
public class MybatisConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
