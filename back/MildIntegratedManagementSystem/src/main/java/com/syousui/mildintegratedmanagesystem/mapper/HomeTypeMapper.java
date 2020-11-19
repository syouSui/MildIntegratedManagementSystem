package com.syousui.mildintegratedmanagesystem.mapper;

import com.syousui.mildintegratedmanagesystem.pojo.po.HomeType;

import java.util.List;

public interface HomeTypeMapper {
    int deleteByPrimaryKey(Integer homeTypeId);

    int insert(HomeType record);

    int insertSelective(HomeType record);

    List<HomeType> selectAll ();

    HomeType selectByPrimaryKey(Integer homeTypeId);

    int updateByPrimaryKeySelective(HomeType record);

    int updateByPrimaryKey(HomeType record);
}