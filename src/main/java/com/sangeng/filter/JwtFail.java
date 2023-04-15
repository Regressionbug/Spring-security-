package com.sangeng.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lixuhang
 * @date 2023/4/13
 * @whatItFor
 */
@Component
public class JwtFail implements AuthenticationFailureHandler {
    private static final Logger logger = LoggerFactory.getLogger(JwtFail.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("进入jwt失败处理方法");
//        httpServletResponse.addCookie(new Cookie("失败","失败value"));
    }
}
