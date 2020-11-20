package com.syousui.mildintegratedmanagesystem;

import com.syousui.mildintegratedmanagesystem.mapper.HomeMapper;
import com.syousui.mildintegratedmanagesystem.mapper.UserMapper;
import com.syousui.mildintegratedmanagesystem.pojo.dto.Page;
import com.syousui.mildintegratedmanagesystem.pojo.po.Home;
import com.syousui.mildintegratedmanagesystem.pojo.po.User;
import com.syousui.mildintegratedmanagesystem.service.UserService;
import com.syousui.mildintegratedmanagesystem.utils.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MildIntegratedManageSystemApplicationTests {

    @Test
    void contextLoads ( ) {
    }

    @Test
    public void testMapper ( ) {
        UserMapper userMapper = SpringUtil.getBean( UserMapper.class );
        List<User> userList = userMapper.selectAll( );
        for ( User user : userList ) {
            System.out.println( user.toString( ) );
        }

        HomeMapper homeMapper = SpringUtil.getBean( HomeMapper.class );
        List<Home> homeList = homeMapper.selectAll( );
        for ( Home home : homeList ) {
            System.out.println( home.toString( ) );
        }
    }

    @Test
    public void testService ( ) {
        UserService userService = SpringUtil.getBean( UserService.class );
        Page page = userService.selectAll( 1, 10 );
        System.out.println(
                "pageNum: " + page.getPageNum( ) + "\n" +
                        "pageSize: " + page.getPageSize( ) + "\n" +
                        "pageTotal: " + page.getPageTotal( ) + "\n" +
                        "totalSize: " + page.getTotalSize( ) + "\n"
        );
        for ( User user : (List<User>) page.getContent( ) ) {
            System.out.println( user );
        }
    }

}
