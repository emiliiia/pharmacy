package com.emilia.pharmacy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import javax.sql.DataSource;

/*
  @author emilia
  @project pharmacy
  @className DataSourceConfig
  @version 1.0.0
  @since 06.08.2022
*/
@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class DataSourceConfig extends GlobalMethodSecurityConfiguration {
    @Bean
    public DataSource getDataSource(@Value("${datasource.url}") String url,
                                    @Value("${datasource.driverClassName}") String driverClassName,
                                    @Value("${datasource.username}") String username,
                                    @Value("${datasource.password}") String password
    ) {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
