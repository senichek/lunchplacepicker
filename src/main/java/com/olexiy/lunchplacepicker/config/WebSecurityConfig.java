package com.olexiy.lunchplacepicker.config;

import com.olexiy.lunchplacepicker.security.UserPrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserPrincipalDetailsService userPrincipalDetailsService;

    public WebSecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/restaurants", "/menus", "/register").permitAll()
                .antMatchers("/admin/**", "/rest/admin/**").hasRole("ADMIN")
                .antMatchers("/profile/**", "/likes", "/rest/profile/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //custom login page, login view must be also returned by controller
                .permitAll()
                .and()
                .csrf().ignoringAntMatchers("/rest/**")
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied")
                .and()
                .httpBasic();
    }
    //TODO
    // Добавить роль мега-админа, чтобы его невозможно было удалить с помощью UI
    // Доделать тесты сервисов
    // Добавить обработку дубликата пользователя при регистрации
    // Сделать возможность смены пароля
    // Добавить сообщение о неверном пароле
    // Добавить сообщение о том, что такого юзера нет в базе данных при попытке логина

    @Bean
    DaoAuthenticationProvider authenticationProvider () {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder () {return new BCryptPasswordEncoder();
    }
}