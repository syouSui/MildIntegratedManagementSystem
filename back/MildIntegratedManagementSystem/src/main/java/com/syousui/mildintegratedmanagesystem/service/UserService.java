package com.syousui.mildintegratedmanagesystem.service;

import com.syousui.mildintegratedmanagesystem.pojo.dto.Page;

import java.util.Date;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : UserService.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.service
 * @createTime : 2020-11-19 19:57:00 星期四
 * @Description : TODO
 */

public interface UserService {
    Page selectSelective ( int pageNum, int pageSize,
                           Integer userId,
                           String username, String password,
                           Integer role,
                           String avatarUrl,
                           String phone, String email,
                           Date createdTime, Date updatedTime
    );
}
