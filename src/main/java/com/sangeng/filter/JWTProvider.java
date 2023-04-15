package com.sangeng.filter;

import com.sangeng.jwt.JwtObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author Lixuhang
 * @date 2023/4/10
 * @whatItFor
 */
@Component
public class JWTProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = ((JwtAuthenticationToken) authentication).getJwtObject().getToken();
        //这里的token只是从cookie取出来没有解析的jwt token
        //这里要进行解析，但是我们忽略这里的解析后校验jwt是否有效内容
        //这里要jwt构建相应的Saml对象，并放回到JwtToken中
        UserDetails userDetails = userDetailsService.loadUserByUsername(token);
        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        //jwtObject应该为token经过解析内部存储的信息后生成的对象
        jwtAuthenticationToken.setJwtObject(new JwtObject(token));
        return jwtAuthenticationToken;

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return JwtAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
