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

import java.util.Date;
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
    public Page selectSelective (
            int pageNum, int pageSize,
            Integer homeId, String title,
            Double priceFrom, Double priceTo,
            Date dateFrom, Date dateTo,
            List<Integer> homeTypeIdList ) {
        PageHelper.startPage( pageNum, pageSize );
        List<Home> homeList = homeMapper.selectSelective(
                homeId==null || homeId == 0 ? null : homeId,
                "".equals( title ) ? null : title,
                priceFrom==null || priceFrom == 0.0 ? null : priceFrom,priceTo==null || priceTo == 0.0 ? null : priceTo,
                dateFrom, dateTo,
                homeTypeIdList
        );
        return new Page(
                new PageInfo<>( homeList )
        );
    }

//    @Override
//    public Page selectAll ( int pageNum, int pageSize ) {
//        PageHelper.startPage( pageNum, pageSize );
//        List<Home> homeList = homeMapper.selectSelective(
//                null,
//                null, null,
//                null, null, null,
//                null
//        );
//        return new Page(
//                new PageInfo<>( homeList )
//        );
//    }
//    @Override
//    public Page selectByPrimaryKey ( int pageNum, int pageSize, Integer homeId ) {
//        PageHelper.startPage( pageNum, pageSize );
//        List<Home> homeList = homeMapper.selectSelective(
//                homeId,
//                null, null,
//                null, null, null,
//                null
//        );
//        return new Page(
//                new PageInfo<>( homeList )
//        );
//    }
//    @Override
//    public Page selectByLikeTitle ( int pageNum, int pageSize, String title ) {
//        PageHelper.startPage( pageNum, pageSize );
//        List<Home> homeList = homeMapper.selectSelective(
//                null,
//                title,
//                null, null,
//                null, null,
//                null
//        );
//        return new Page(
//                new PageInfo<>( homeList )
//        );
//    }
//    @Override
//    public Page selectByPriceRange ( int pageNum, int pageSize, Double from, Double to ) {
//        PageHelper.startPage( pageNum, pageSize );
//        List<Home> homeList = homeMapper.selectSelective(
//                null,
//                null,
//                from, to,
//                null, null,
//                null
//        );
//        return new Page(
//                new PageInfo<>( homeList )
//        );
//    }
//    @Override
//    public Page selectByDateRange ( int pageNum, int pageSize, Date from, Date to ) {
//        PageHelper.startPage( pageNum, pageSize );
//        List<Home> homeList = homeMapper.selectSelective(
//                null,
//                null,
//                null, null,
//                from, to,
//                null
//        );
//        return new Page(
//                new PageInfo<>( homeList )
//        );
//    }
//    @Override
//    public Page selectByHomeTypeId ( int pageNum, int pageSize, List<Integer> list ) {
//        PageHelper.startPage( pageNum, pageSize );
//        List<Home> homeList = homeMapper.selectSelective(
//                null,
//                null,
//                null, null,
//                null, null,
//                list
//        );
//        return new Page(
//                new PageInfo<>( homeList )
//        );
//    }
}
