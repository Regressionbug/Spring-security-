package com.sangeng.controller;

import com.sangeng.query.domain.AuthRole;
import com.sangeng.query.mapper.AuthRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    AuthRoleMapper authRoleMapper;

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public String hello(){
        List<String> permissionByUserId = authRoleMapper.getPermissionByUserId("1");
        List<AuthRole> authRoles = authRoleMapper.selectAll();
        return "hello";
    }
}
