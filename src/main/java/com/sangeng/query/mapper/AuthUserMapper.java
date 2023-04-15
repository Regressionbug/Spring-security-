package com.sangeng.query.mapper;

import com.sangeng.query.domain.AuthUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
//@Mapper
public interface AuthUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(AuthUser record);

    AuthUser selectByPrimaryKey(String userId);

    List<AuthUser> selectAll();

    int updateByPrimaryKey(AuthUser record);
}