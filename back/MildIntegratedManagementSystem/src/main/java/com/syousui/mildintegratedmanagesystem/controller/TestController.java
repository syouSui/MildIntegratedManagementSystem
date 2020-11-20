package com.syousui.mildintegratedmanagesystem.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.syousui.mildintegratedmanagesystem.pojo.po.User;
import com.syousui.mildintegratedmanagesystem.pojo.vo.ResultVo;
import com.syousui.mildintegratedmanagesystem.service.UserService;
import com.syousui.mildintegratedmanagesystem.utils.JsonUtil;
import com.syousui.mildintegratedmanagesystem.utils.SpringUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestController.java
 * @PackageLoaction : com.syousui.controller
 * @createTime : 2020-11-19 09:55:00 &#x661F;&#x671F;&#x56DB;
 * @Description : TODO
 */

@Api ( tags = "测试接口" )
@RestController ()
@RequestMapping ( "/Test" )
public class TestController {
    @GetMapping ( "/test" )
    public String test ( ) {
        System.out.println( "test111" );
        return "hello /Test/test";
    }

    @ApiOperation ( value = "分页获取用户测试数据" )
    @ApiImplicitParams ( {
            @ApiImplicitParam ( name = "pageNum", value = "页面编码", required = true, paramType = "query", dataType = "JsonNode" ),
            @ApiImplicitParam ( name = "pageSize", value = "页面大小", required = true, paramType = "query", dataType = "JsonNode" )
    } )
    @GetMapping ( "/getJson" )
    public String json_get ( @RequestBody JsonNode jsonNode ) {
        System.out.println( "test jon1111" );
        return JsonUtil.beanToJson(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        SpringUtil.getBean( UserService.class ).selectAll(
                                jsonNode.at( "/pageNum" ).asInt( ), jsonNode.at( "/pageSize" ).asInt( )
                        )
                )
        );
    }

    @ApiOperation ( value = "测试用户注册" )
    @ApiImplicitParams ( {
            @ApiImplicitParam ( name = "user", value = "用户类", required = true, paramType = "query", dataType = "User" )
    } )
    @PostMapping ( "/setJson1" )
    public String json_set1 ( @RequestBody User user ) {
        System.out.println( "" + user + "" );
        return JsonUtil.beanToJson(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        user
                )
        );
    }

    @ApiOperation ( value = "测试自定义json" )
    @ApiImplicitParams ( {
            @ApiImplicitParam ( name = "state", value = "状态", required = true, paramType = "query", dataType = "JsonNode" ),
            @ApiImplicitParam ( name = "content", value = "内容", required = true, paramType = "query", dataType = "JsonNode" )
    } )
    @PostMapping ( "/setJson2" )
    public String json_set2 ( @RequestBody JsonNode jsonNode ) {
        System.out.println( jsonNode.at( "/state" ).asInt( ) + ", " + jsonNode.at( "/content" ).asText( ) );
        return JsonUtil.beanToJson(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        new HashMap<String, Object>( ) {
                            {
                                put( "state", jsonNode.at( "/state" ).asInt( ) * 200 );
                                put( "content", jsonNode.at( "/content" ).asText( ) + "988YU2IYU2IH2SF4568956948498479SDF" );
                            }
                        }
                )
        );
    }
}

