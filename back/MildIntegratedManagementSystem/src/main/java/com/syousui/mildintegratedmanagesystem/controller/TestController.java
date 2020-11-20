package com.syousui.mildintegratedmanagesystem.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.syousui.mildintegratedmanagesystem.pojo.po.User;
import com.syousui.mildintegratedmanagesystem.pojo.vo.ResultVo;
import com.syousui.mildintegratedmanagesystem.service.UserService;
import com.syousui.mildintegratedmanagesystem.utils.JsonUtil;
import com.syousui.mildintegratedmanagesystem.utils.SpringUtil;
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

@RestController ()
@RequestMapping ( "/Test" )
public class TestController {
    @GetMapping ( "/test" )
    public String test ( ) {
        System.out.println( "test111" );
        return "hello /Test/test";
    }

    @GetMapping ( "/getJson" )
    public String json_get ( ) {
        System.out.println( "test jon1111" );
        UserService userService = SpringUtil.getBean( UserService.class );
        return JsonUtil.beanToJson(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        userService.selectAll( 1, 10 )
                )
        );
    }

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

    @PostMapping ( "/setJson2" )
    public String json_set2 (
            @RequestBody JsonNode jsonNode ) {
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

