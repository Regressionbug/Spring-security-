package com.sangeng.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AuthenticationSuccessHandler successHandler;
//
//    @Autowired
//    private AuthenticationFailureHandler failureHandler;
//
//    @Autowired
//    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private List<AbstractHttpConfigurer> httpConfigurers;

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
////                配置认证成功处理器
//                .successHandler(successHandler)
////                配置认证失败处理器
//                .failureHandler(failureHandler);
//
//        http.logout()
//                //配置注销成功处理器
//                .logoutSuccessHandler(logoutSuccessHandler);
//
//        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
        if(httpConfigurers!=null) {
            for (AbstractHttpConfigurer httpConfigurer : httpConfigurers) {
                http.apply(httpConfigurer);
            }
        }
        http.antMatcher("/hello").anonymous();

    }
}
