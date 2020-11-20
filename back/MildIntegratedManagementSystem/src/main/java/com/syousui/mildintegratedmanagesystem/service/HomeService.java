package com.syousui.mildintegratedmanagesystem.service;

import com.syousui.mildintegratedmanagesystem.pojo.dto.Page;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : HomeService.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.service
 * @createTime : 2020-11-19 19:57:00 星期四
 * @Description : TODO
 */

public interface HomeService {
    Page selectAll ( int pageNum, int pageSize );
}
