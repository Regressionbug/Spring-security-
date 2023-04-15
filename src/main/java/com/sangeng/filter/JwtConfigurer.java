package com.sangeng.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

/**
 * @author Lixuhang
 * @date 2023/4/10
 * @whatItFor
 */
@Configuration
public class JwtConfigurer<T extends JwtConfigurer<T,B>,B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T,B> {

    @Autowired
    JwtSuccess jwtSuccess;

    @Autowired
    JwtFail jwtFail;

    @Autowired
    JWTProvider jwtProvider;

    @Override
    public void configure(B builder) throws Exception {
        JWTFilter jwtFilter = new JWTFilter(AnyRequestMatcher.INSTANCE);
        jwtFilter.setAuthenticationManager(builder.getSharedObject(AuthenticationManager.class));
        jwtFilter.setAuthenticationSuccessHandler(jwtSuccess);
        jwtFilter.setAuthenticationFailureHandler(jwtFail);

        builder.addFilterBefore(postProcess(jwtFilter), CsrfFilter.class)
                .authenticationProvider(jwtProvider);
    }
}
