package com.olexiy.lunchplacepicker.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

@Configuration
public class Webconfig implements WebMvcConfigurer {

    /*@Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder
        .url("jdbc:postgresql://localhost:5432/lunchplacepicker")
        .username("postgres")
        .password("password");
        return dataSourceBuilder.build();
    }*/

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder
                .url("jdbc:postgresql://ec2-54-228-9-90.eu-west-1.compute.amazonaws.com:5432/du6ldu7muvl9k")
                .username("lhtvririnawcdg")
                .password("c87b15fb9fbbc6f555b4fb887b06f505c7edc42c5714731ad26f8f61ef46c71f");
        return dataSourceBuilder.build();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer (){
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("/database/InitDB.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/database/PopulateDB.sql"));
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource());
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }

    @Bean
    public ObjectMapper jacksonObjectMapper() {
        return JacksonObjectMapper.getMapper();
    }
}
