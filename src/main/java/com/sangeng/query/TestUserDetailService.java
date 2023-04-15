package com.sangeng.query;

import com.sangeng.filter.JWTUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Lixuhang
 * @date 2023/4/13
 * @whatItFor
 */
@Service
public class TestUserDetailService implements UserDetailsService {


    @Override
    public JWTUser loadUserByUsername(String s) throws UsernameNotFoundException {
        //模拟进行权限的查询

        List<String> permissions = new ArrayList<String>(Arrays.asList("test"));
        //进行权限的转换
        Set<SimpleGrantedAuthority> authoritySet =
                permissions.stream().map(str -> new SimpleGrantedAuthority(str)).collect(Collectors.toSet());
        //模拟进行角色
        JWTUser jwtUser = new JWTUser();
        jwtUser.setAuthorities(authoritySet);
        return jwtUser;
    }
}
