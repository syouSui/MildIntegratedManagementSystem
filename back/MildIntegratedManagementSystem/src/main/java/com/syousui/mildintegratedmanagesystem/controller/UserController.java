package com.syousui.mildintegratedmanagesystem.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.syousui.mildintegratedmanagesystem.pojo.po.User;
import com.syousui.mildintegratedmanagesystem.pojo.vo.ResultVo;
import com.syousui.mildintegratedmanagesystem.service.UserService;
import com.syousui.mildintegratedmanagesystem.utils.JsonUtil;
import com.syousui.mildintegratedmanagesystem.utils.SpringUtil;
import com.syousui.mildintegratedmanagesystem.utils.WebUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : UserController.java
 * @PackageLocation : com.syousui.mildintegratedmanagesystem.controller
 * @createTime : 2020-11-23 19:34:00 星期一
 * @Description : TODO
 */

@Api ( tags = "用户接口" )
@RestController ()
@RequestMapping ( "/User" )
public class UserController {
    @ApiOperation ( value = "用户登录" )
    @ApiImplicitParams ( {
            @ApiImplicitParam ( name = "username", value = "用户名", required = true, paramType = "query", dataType = "JsonNode" ),
            @ApiImplicitParam ( name = "password", value = "密码", required = true, paramType = "query", dataType = "JsonNode" )
    } )
    @PostMapping ( "/Login" )
    public String login ( @RequestBody JsonNode jsonNode ) {
        System.out.println( "login:\t" + jsonNode.at( "/username" ).asText( ) + "\t" + jsonNode.at( "/password" ).asText( ) );
        List pageContentList = SpringUtil.getBean( UserService.class ).selectSelective(
                1, 1,
                false,
                null,
                jsonNode.at( "/username" ).asText( ), jsonNode.at( "/password" ).asText( ),
                null,
                null,
                null, null,
                null, null
        ).getContent( );
//        User user = pageContentList.size( ) == 1 ? (User) pageContentList.get( 0 ) : null;
        User user;
        if ( pageContentList.size( ) == 1 ) {
            user = (User) pageContentList.get( 0 );
            WebUtil.login( user );
        } else {
            user = null;
        }
        return JsonUtil.beanToJson(
                new ResultVo(
                        user != null ? ResultVo.CODE_SUCCESS : ResultVo.CODE_FAILED,
                        user != null ? "login successfully!" : "username or password error!",
                        null
                )
        );
    }

    @ApiOperation ( value = "用户注销" )
    @ApiImplicitParams ( {
            @ApiImplicitParam ( name = "password", value = "密码", required = true, paramType = "query", dataType = "JsonNode" )
    } )
    @PostMapping ( "/Logout" )
    public String logout ( ) {
        boolean state = WebUtil.logOut( );
        return JsonUtil.beanToJson(
                new ResultVo(
                        state ? ResultVo.CODE_SUCCESS : ResultVo.CODE_FAILED,
                        state ? "logout successfully!" : "logout failed!",
                        null
                )
        );
    }

    @ApiOperation ( value = "用户注册" )
    @ApiImplicitParams ( {
            @ApiImplicitParam ( name = "user", value = "用户类", required = true, paramType = "query", dataType = "User" )
    } )
    @PostMapping ( "/Register" )
    public String register ( @RequestBody JsonNode jsonNode ) {
        int counter = 0;
        counter = SpringUtil.getBean( UserService.class ).insert(
                new User(
                        jsonNode.at( "/username" ).asText( ),
                        jsonNode.at( "/password" ).asText( ),
                        0,
                        jsonNode.at( "/avatarUrl" ).asText( ),
                        jsonNode.at( "/phone" ).asText( ),
                        jsonNode.at( "/email" ).asText( ),
                        new Date( ), new Date( )
                ), false
        );
        return JsonUtil.beanToJson(
                new ResultVo(
                        counter != 0 ? ResultVo.CODE_SUCCESS : ResultVo.CODE_FAILED,
                        counter != 0 ? "register successfully!" : "register failed!",
                        null
                )
        );
    }

    @ApiOperation ( value = "用户更新" )
    @ApiImplicitParams ( {
            @ApiImplicitParam ( name = "user", value = "用户类", required = true, paramType = "query", dataType = "User" )
    } )
    @PutMapping ( "/Update" )
    public String update ( @RequestBody JsonNode jsonNode ) {
        int role = 0;
        int userRole = WebUtil.fetchUser( ).getRole( );
        int receivedRole = jsonNode.at( "/role" ).asInt( );
        if ( userRole == 2 ) {
            role = receivedRole > 1 || receivedRole < 0 ? 0 : receivedRole;
        } else if ( receivedRole == 1 ) {
            role = 0;
        }
        int counter = 0;
        counter = SpringUtil.getBean( UserService.class ).update(
                new User(
                        jsonNode.at( "/username" ).asText( ),
                        jsonNode.at( "/password" ).asText( ),
                        role,
                        jsonNode.at( "/avatarUrl" ).asText( ),
                        jsonNode.at( "/phone" ).asText( ),
                        jsonNode.at( "/email" ).asText( ),
                        new Date( ), new Date( )
                ), false
        );
        return JsonUtil.beanToJson(
                new ResultVo(
                        counter != 0 ? ResultVo.CODE_SUCCESS : ResultVo.CODE_FAILED,
                        counter != 0 ? "register successfully!" : "register failed!",
                        null
                )
        );
    }
}
