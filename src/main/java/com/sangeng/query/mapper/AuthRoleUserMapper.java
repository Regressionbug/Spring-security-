package com.sangeng.query.mapper;

import com.sangeng.query.domain.AuthRoleUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
//@Mapper
public interface AuthRoleUserMapper {
    int deleteByPrimaryKey(String userRoleId);

    int insert(AuthRoleUser record);

    AuthRoleUser selectByPrimaryKey(String userRoleId);

    List<AuthRoleUser> selectAll();

    int updateByPrimaryKey(AuthRoleUser record);
}