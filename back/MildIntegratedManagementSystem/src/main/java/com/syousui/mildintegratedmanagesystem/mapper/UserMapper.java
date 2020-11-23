package com.syousui.mildintegratedmanagesystem.mapper;

import com.syousui.mildintegratedmanagesystem.pojo.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserMapper {
    int insert ( User record );

    int insertSelective ( User record );

    int deleteByPrimaryKey ( Integer userId );

    int updateByPrimaryKeySelective ( User record );

    int updateByPrimaryKey ( User record );

    List<User> selectSelective (
            @Param ( "userId" ) Integer userId,
            @Param ( "username" ) String username, @Param ( "password" ) String password,
            @Param ( "role" ) Integer role,
            @Param ( "avatarUrl" ) String avatarUrl,
            @Param ( "phone" ) String phone, @Param ( "email" ) String email,
            @Param ( "createdTime" ) Date createdTime, @Param ( "updatedTime" ) Date updatedTime
    );

//    List<User> selectAll ();
//
//    User selectByPrimaryKey(Integer userId);
}