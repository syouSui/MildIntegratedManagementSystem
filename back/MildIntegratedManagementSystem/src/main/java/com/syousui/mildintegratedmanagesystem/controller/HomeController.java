package com.syousui.mildintegratedmanagesystem.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.syousui.mildintegratedmanagesystem.pojo.vo.ResultVo;
import com.syousui.mildintegratedmanagesystem.service.HomeService;
import com.syousui.mildintegratedmanagesystem.utils.DateUtil;
import com.syousui.mildintegratedmanagesystem.utils.JsonUtil;
import com.syousui.mildintegratedmanagesystem.utils.SpringUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : HomeController.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.controller
 * @createTime : 2020-11-23 19:33:00 星期一
 * @Description : TODO
 */


@Api ( tags = "房屋接口" )
@RestController ()
@RequestMapping ( "/Home" )
public class HomeController {
    @PostMapping ( "/insert" )
    public String insert ( @RequestBody JsonNode jsonNode ) {
        System.out.println( "home update." );
        return JsonUtil.beanToJson(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "update home successfully!",
                        SpringUtil.getBean( HomeService.class ).insert(
                                jsonNode.at( "/homeId" ).asInt( ),
                                jsonNode.at( "/title" ).asText( ),
                                jsonNode.at( "/price" ).asDouble( ),
                                new Date(),
                                jsonNode.at("/homeTypeId").asInt(),
                                true
                        )
                )
        );
    }

    @PostMapping ( "/delete" )
    public String delete ( @RequestBody JsonNode jsonNode ) {
        System.out.println( "home update." );
        return JsonUtil.beanToJson(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "delete home successfully!",
                        SpringUtil.getBean( HomeService.class ).delete(
                                jsonNode.at( "/homeId" ).asInt( )
                        )
                )
        );
    }

    @PostMapping ( "/update" )
    public String update ( @RequestBody JsonNode jsonNode ) {
        System.out.println( "home update." );
        return JsonUtil.beanToJson(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "update home successfully!",
                        SpringUtil.getBean( HomeService.class ).update(
                                jsonNode.at( "/homeId" ).asInt( ),
                                jsonNode.at( "/title" ).asText( ),
                                jsonNode.at( "/price" ).asDouble( ),
                                new Date(),
                                jsonNode.at("/homeTypeId").asInt(),
                                true
                        )
                )
        );
    }

    @PostMapping ( "/" )
    public String select ( @RequestBody JsonNode jsonNode ) {
        System.out.println( "home select." );
        return JsonUtil.beanToJson(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "select home successfully!",
                        SpringUtil.getBean( HomeService.class ).selectSelective(
                                jsonNode.at( "/pageNum" ).asInt( ), 10,
                                jsonNode.at( "/homeId" ).asInt( ),
                                jsonNode.at( "/title" ).asText( ),
                                jsonNode.at( "/priceFrom" ).asDouble( ), jsonNode.at( "/priceTo" ).asDouble( ),
                                DateUtil.asDate( jsonNode.at( "/dataFrom" ).asText( ) ), DateUtil.asDate( jsonNode.at( "/dataFrom" ).asText( ) ),
                                JsonUtil.jsonNodeToIntList( jsonNode.at( "/homeTypeIdList" ) )
                        )
                )
        );
    }

}
