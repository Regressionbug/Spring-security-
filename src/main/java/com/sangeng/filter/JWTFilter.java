package com.sangeng.filter;

import com.sangeng.jwt.JwtObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

/**
 * @author Lixuhang
 * @date 2023/4/10
 * @whatItFor
 */
public class JWTFilter extends AbstractAuthenticationProcessingFilter {

    public JWTFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        //进行token解析
        Authentication authentication = this.attemptAuthentication(servletRequest, servletResponse);
        if(authentication == null){
            return;
        }
        this.successfulAuthentication(servletRequest,servletResponse,chain,authentication);
        chain.doFilter(request,response);

        //解析后，从缓存中读取相应的用户数据，其中包含权限
        //这里实际操作时，调用attemptAuthencation，在其中实际调用的对应的Provider来提供token对token和cookie的校验，后后续从缓存中查询的操作
        //查询之后，进行封装，这里所有的逻辑改写自相应的流程链，如果没有相应的null

        //将权限封装在AuthenticationToken当中，返回，
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String token = httpServletRequest.getHeader("token");
        //解析token，并取出其中的字段（这里可以选择使用cookie方式），暂时将Username=token
        AuthenticationManager authenticationManager = this.getAuthenticationManager();
        Authentication authenticate = authenticationManager.authenticate(new JwtAuthenticationToken(new JwtObject(token), token));
        return authenticate;
    }
}
