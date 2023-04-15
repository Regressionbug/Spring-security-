package com.sangeng.query.mapper;

import com.sangeng.query.domain.AuthRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
//@Mapper
public interface AuthRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(AuthRole record);

    AuthRole selectByPrimaryKey(String roleId);

    List<AuthRole> selectAll();

    int updateByPrimaryKey(AuthRole record);

    List<String> getPermissionByUserId(String userId);
}