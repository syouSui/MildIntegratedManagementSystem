package com.syousui.mildintegratedmanagesystem.controller;

import com.syousui.mildintegratedmanagesystem.mapper.UserMapper;
import com.syousui.mildintegratedmanagesystem.utils.SpringUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
