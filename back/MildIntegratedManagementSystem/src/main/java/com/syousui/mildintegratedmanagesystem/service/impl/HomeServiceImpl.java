package com.syousui.mildintegratedmanagesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syousui.mildintegratedmanagesystem.mapper.HomeMapper;
import com.syousui.mildintegratedmanagesystem.pojo.dto.Page;
import com.syousui.mildintegratedmanagesystem.pojo.po.Home;
import com.syousui.mildintegratedmanagesystem.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : HomeServiceImpl.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.service.impl
 * @createTime : 2020-11-19 19:59:00 星期四
 * @Description : TODO
 */

@Service
@Transactional
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;

    @Override
    public Page selectAll ( int pageNum, int pageSize ) {
        PageHelper.startPage( pageNum, pageSize );
        List<Home> homeList = homeMapper.selectAll( );
        return new Page(
                new PageInfo<>( homeList )
        );
    }
}
