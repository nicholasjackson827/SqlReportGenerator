package com.ngjackson.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  @Primary
  public DataSource mySqlDatasource() {
    return DataSourceBuilder.create().build();
  }
}
