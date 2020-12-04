package com.syousui.mildintegratedmanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syousui.mildintegratedmanagesystem.mapper.UserMapper;
import com.syousui.mildintegratedmanagesystem.pojo.dto.Page;
import com.syousui.mildintegratedmanagesystem.pojo.po.User;
import com.syousui.mildintegratedmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : UserServiceImpl.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.service.impl
 * @createTime : 2020-11-19 20:02:00 星期四
 * @Description : TODO
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page selectSelective ( int pageNum, int pageSize,
                                  Boolean isUsernameLike,
                                  Integer userId,
                                  String username, String password,
                                  Integer role,
                                  String avatarUrl,
                                  String phone, String email,
                                  Date createdTime, Date updatedTime ) {
        PageHelper.startPage( pageNum, pageSize );
        List<User> userList = userMapper.selectSelective(
                isUsernameLike,
                userId == null || userId == 0 ? null : userId,
                "".equals( username ) ? null : username, "".equals( password ) ? null : password,
                role,
                "".equals( avatarUrl ) ? null : avatarUrl,
                "".equals( phone ) ? null : phone, "".equals( email ) ? null : email,
                createdTime, updatedTime
        );
        return new Page(
                new PageInfo<>( userList )

        );
    }

    public int insert ( User user, Boolean isForced ) {
        user.setAvatarUrl( "".equals( user.getAvatarUrl( ) ) || null == user.getAvatarUrl( ) ?
                null : user.getAvatarUrl( )
        );
        user.setPhone( "".equals( user.getPhone()) ? null : user.getPhone( ) );
        user.setEmail( "".equals( user.getEmail()) ? null : user.getEmail( ) );
        return isForced ?
                userMapper.insert( user ) :
                userMapper.insertSelective( user );
    }

    public int update ( User user, Boolean isForced ) {
        return isForced ?
                userMapper.updateByPrimaryKey( user ) :
                userMapper.updateByPrimaryKeySelective( user );
    }
    @Override
    public int delete ( Integer userId ) {
        return userMapper.deleteByPrimaryKey( userId );
    }
}
