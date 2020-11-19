package com.syousui.mildintegratedmanagesystem.mapper;

import com.syousui.mildintegratedmanagesystem.pojo.po.Home;

import java.util.List;

public interface HomeMapper {
    int deleteByPrimaryKey(Integer homeId);

    int insert(Home record);

    int insertSelective(Home record);

    List<Home> selectAll ();

    Home selectByPrimaryKey(Integer homeId);

    int updateByPrimaryKeySelective(Home record);

    int updateByPrimaryKey(Home record);
}