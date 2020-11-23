package com.syousui.mildintegratedmanagesystem;

import com.syousui.mildintegratedmanagesystem.mapper.HomeMapper;
import com.syousui.mildintegratedmanagesystem.mapper.UserMapper;
import com.syousui.mildintegratedmanagesystem.pojo.dto.Page;
import com.syousui.mildintegratedmanagesystem.pojo.po.Home;
import com.syousui.mildintegratedmanagesystem.pojo.po.User;
import com.syousui.mildintegratedmanagesystem.service.UserService;
import com.syousui.mildintegratedmanagesystem.utils.DateUtil;
import com.syousui.mildintegratedmanagesystem.utils.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MildIntegratedManageSystemApplicationTests {

    @Test
    void contextLoads ( ) {
    }

//    @Test
//    public void testMapper ( ) {
//        UserMapper userMapper = SpringUtil.getBean( UserMapper.class );
//        List<User> userList = userMapper.selectAll( );
//        for ( User user : userList ) {
//            System.out.println( user.toString( ) );
//        }
//
//        HomeMapper homeMapper = SpringUtil.getBean( HomeMapper.class );
//        List<Home> homeList = homeMapper.selectAll( );
//        for ( Home home : homeList ) {
//            System.out.println( home.toString( ) );
//        }
//    }
//
//    @Test
//    public void testService ( ) {
//        UserService userService = SpringUtil.getBean( UserService.class );
//        Page page = userService.selectAll( 1, 10 );
//        System.out.println(
//                "pageNum: " + page.getPageNum( ) + "\n" +
//                        "pageSize: " + page.getPageSize( ) + "\n" +
//                        "pageTotal: " + page.getPageTotal( ) + "\n" +
//                        "totalSize: " + page.getTotalSize( ) + "\n"
//        );
//        for ( User user : (List<User>) page.getContent( ) ) {
//            System.out.println( user );
//        }
//    }

    @Test
    public void test_new_add_select ( ) {
        HomeMapper homeMapper = SpringUtil.getBean( HomeMapper.class );
//        List<Home> homeList = homeMapper.selectByLikeTitle( "Comp" );
//        List<Home> homeList = homeMapper.selectByPriceRange( 88888.0, 99999.0 );
//        List<Home> homeList = homeMapper.selectByDateRange(
//                DateUtil.asDate( "2012-09-10 11:22:22" ),
//                DateUtil.asDate( "2018-09-10 11:22:22" )
//        );
//        List<Home> homeList = homeMapper.selectByHomeTypeId(
//                Arrays.asList( 1, 2 )
//        );
//
//        List<Home> homeList = homeMapper.selectSelective(
//                null,
//                "Comp",
//                11111.1, 99999.9,
//                DateUtil.asDate( "2012-09-10 11:22:22" ),
//                DateUtil.asDate( "2020-09-10 11:22:22" ),
//                Arrays.asList( 0, 1, 2, 3, 4 )
//        );
        List<Home> homeList = homeMapper.selectSelective(
                null,
                null,
                null, null,
                null, null,
                Arrays.asList( 0, 1, 2, 3, 4 )
        );
        for ( Home home : homeList ) {
            System.out.println( home.toString( ) );
        }
    }

}
