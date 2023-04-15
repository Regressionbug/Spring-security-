package com.sangeng.filter;

import com.sangeng.jwt.JwtObject;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Lixuhang
 * @date 2023/4/10
 * @whatItFor
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;
    private Object credentials;
    private JwtObject jwtObject;

    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        if(authorities == null){
            this.setAuthenticated(false);
        }
        else {
            this.setAuthenticated(true);
        }
    }

    public JwtAuthenticationToken(Object principal, Object credentials){
        this(principal,credentials,null);
    }

    public JwtAuthenticationToken(JwtObject jwtObject,String userName) {
        this(userName,null);
        this.jwtObject = jwtObject;
    }

    public JwtObject getJwtObject() {
        return jwtObject;
    }

    public void setJwtObject(JwtObject jwtObject) {
        this.jwtObject = jwtObject;
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}
