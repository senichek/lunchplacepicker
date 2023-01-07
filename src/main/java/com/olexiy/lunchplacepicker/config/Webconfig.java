package com.olexiy.lunchplacepicker.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olexiy.lunchplacepicker.utils.StringToInteger;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.FormatterRegistry;
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
                .url("jdbc:postgresql://portfolio-do-user-13257331-0.b.db.ondigitalocean.com:25060/lunch_place_picker?sslmode=require")
                .username("doadmin")
                .password("AVNS_zVT7peLfoVMJWx_Y4-t");
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

    @Override
    public void addFormatters(FormatterRegistry registry) {
        StringToInteger converter = new StringToInteger();
        registry.addConverter(converter);
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
