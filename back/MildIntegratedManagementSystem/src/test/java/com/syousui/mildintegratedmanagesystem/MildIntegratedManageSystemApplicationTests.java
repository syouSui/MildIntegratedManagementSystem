package com.syousui.mildintegratedmanagesystem;

import com.syousui.mildintegratedmanagesystem.mapper.HomeMapper;
import com.syousui.mildintegratedmanagesystem.mapper.HomeTypeMapper;
import com.syousui.mildintegratedmanagesystem.mapper.UserMapper;
import com.syousui.mildintegratedmanagesystem.pojo.po.Home;
import com.syousui.mildintegratedmanagesystem.pojo.po.HomeType;
import com.syousui.mildintegratedmanagesystem.pojo.po.User;
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

        HomeTypeMapper homeTypeMapper = SpringUtil.getBean( HomeTypeMapper.class );
        List<HomeType> homeTypeList = homeTypeMapper.selectAll( );
        for ( HomeType homeType : homeTypeList ) {
            System.out.println( homeType.toString( ) );
        }
    }

}
