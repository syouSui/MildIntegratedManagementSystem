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
    public Page selectAll ( int pageNum, int pageSize ) {
        PageHelper.startPage( pageNum, pageSize );
        List<User> userList = userMapper.selectAll( );
        return new Page(
                new PageInfo<>( userList )
        );
    }
}
