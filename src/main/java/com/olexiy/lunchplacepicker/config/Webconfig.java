package com.olexiy.lunchplacepicker.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Webconfig implements WebMvcConfigurer {

    private static final Charset UTF8 = Charset.forName("UTF-8");

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
                .url("jdbc:postgresql://ec2-34-254-120-2.eu-west-1.compute.amazonaws.com:5432/db8d84mne4ma4k")
                .username("ywxmtnhgmvlutz")
                .password("0fdbab19309612259eaca1dc3361ba2a02b61f86f9618253b28147ecb4f4eea1");
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
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
        converters.add(stringConverter);
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
