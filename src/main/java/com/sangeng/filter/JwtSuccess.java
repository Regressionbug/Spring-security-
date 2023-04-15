package com.sangeng.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
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
public class JwtSuccess implements AuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(JwtSuccess.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("进入jwt验证的成功方法");
//        httpServletResponse.addCookie(new Cookie("成功","成功value"));
    }
}
