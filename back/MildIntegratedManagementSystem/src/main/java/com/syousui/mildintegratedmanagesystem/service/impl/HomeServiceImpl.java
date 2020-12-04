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
                homeId == null || homeId == 0 ? null : homeId,
                "".equals( title ) ? null : title,
                priceFrom == null || priceFrom == 0.0 ? null : priceFrom, priceTo == null || priceTo == 0.0 ? null : priceTo,
                dateFrom, dateTo,
                homeTypeIdList.size( ) == 0 ? null : homeTypeIdList
        );
        return new Page(
                new PageInfo<>( homeList )
        );
    }

    @Override
    public int update (
            Integer homeId,
            String title,
            Double price,
            Date updatedDate,
            Integer homeTypeId,
            Boolean isForceUpdatedWithHomeId ) {
        Home home = new Home(
                        homeId,
                        "".equals( title ) ? null : title,
                        price == null || price == 0.0 ? null : price,
                        updatedDate,
                        homeTypeId == null || homeTypeId == 0 ? null : homeTypeId
                );
        return isForceUpdatedWithHomeId ? homeMapper.updateByPrimaryKey( home ) : homeMapper.updateByPrimaryKeySelective( home ) ;

    }
    @Override
    public int insert ( Integer homeId, String title, Double price, Date updatedDate, Integer homeTypeId, Boolean isForceInsert ) {
        Home home = new Home(
                homeId,
                "".equals( title ) ? null : title,
                price == null || price == 0.0 ? null : price,
                updatedDate,
                homeTypeId == null || homeTypeId == 0 ? null : homeTypeId
        );
        return isForceInsert  ? homeMapper.insert( home ) : homeMapper.insertSelective( home ) ;
    }
    @Override
    public int delete ( Integer homeId ) {
        return homeMapper.deleteByPrimaryKey( homeId );
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
