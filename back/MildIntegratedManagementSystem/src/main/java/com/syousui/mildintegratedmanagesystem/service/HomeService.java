package com.syousui.mildintegratedmanagesystem.service;

import com.syousui.mildintegratedmanagesystem.pojo.dto.Page;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : HomeService.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.service
 * @createTime : 2020-11-19 19:57:00 星期四
 * @Description : TODO
 */

public interface HomeService {
    Page selectSelective ( int pageNum, int pageSize,
                           Integer homeId,
                           String title,
                           Double priceFrom, Double priceTo,
                           Date dateFrom, Date dateTo,
                           List<Integer> homeTypeIdList
    );

   int update (
            Integer homeId,
            String title,
            Double price,
            Date updatedDate,
            Integer homeTypeId,
            Boolean isForceUpdatedWithHomeId );

    int insert (
            Integer homeId,
            String title,
            Double price,
            Date updatedDate,
            Integer homeTypeId,
            Boolean isForceInsert );

    int delete (
            Integer homeId );

//    Page selectAll ( int pageNum, int pageSize );
//
//    Page selectByPrimaryKey ( int pageNum, int pageSize, Integer homeId );
//
//    Page selectByLikeTitle ( int pageNum, int pageSize, String title );
//
//    Page selectByPriceRange ( int pageNum, int pageSize, Double from, Double to );
//
//    Page selectByDateRange ( int pageNum, int pageSize, Date from, Date to );
//
//    Page selectByHomeTypeId ( int pageNum, int pageSize, List<Integer> list );
}
