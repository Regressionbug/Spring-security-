package com.sangeng.filter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Lixuhang
 * @date 2023/4/10
 * @whatItFor
 */
public class JWTUser implements UserDetails {
    private Collection<? extends GrantedAuthority> authorities;

    private String userName;

    private String loginName;

    private Boolean isBank;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getBank() {
        return isBank;
    }

    public void setBank(Boolean bank) {
        isBank = bank;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    //我们使用自己的机制进行过期判断，所以这里直接放回true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
