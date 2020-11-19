package com.syousui.mildintegratedmanagesystem;

import com.syousui.mildintegratedmanagesystem.pojo.po.TestIoc;
import com.syousui.mildintegratedmanagesystem.utils.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MildIntegratedManageSystemApplicationTests {

    @Test
    void contextLoads ( ) {
    }

    @Test
    void testIoc ( ) {
        System.out.println( SpringUtil.getBean( TestIoc.class ) );
    }

}
