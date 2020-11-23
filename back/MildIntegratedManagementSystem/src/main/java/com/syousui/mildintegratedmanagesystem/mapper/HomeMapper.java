package com.syousui.mildintegratedmanagesystem.mapper;

import com.syousui.mildintegratedmanagesystem.pojo.po.Home;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HomeMapper {
    int insert ( Home record );

    int insertSelective ( Home record );

    int deleteByPrimaryKey ( Integer homeId );

    int updateByPrimaryKeySelective ( Home record );

    int updateByPrimaryKey ( Home record );

    List<Home> selectSelective (
            @Param( "homeId" ) Integer homeId,
            @Param ( "title" ) String title,
            @Param ( "priceFrom" ) Double priceFrom, @Param ( "priceTo" ) Double priceTo,
            @Param ( "dateFrom" ) Date dateFrom, @Param ( "dateTo" ) Date dateTo,
            @Param ( "homeTypeIdList" ) List<Integer> homeTypeIdList
    );
}