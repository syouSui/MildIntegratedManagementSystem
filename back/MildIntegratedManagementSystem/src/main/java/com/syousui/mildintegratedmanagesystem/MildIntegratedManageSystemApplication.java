package com.syousui.mildintegratedmanagesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan ( "com.syousui.mildintegratedmanagesystem.mapper" )
@ComponentScan ( "com.syousui.mildintegratedmanagesystem.mapper" )
@ComponentScan ( "com.syousui.mildintegratedmanagesystem.service" )
@ComponentScan ( "com.syousui.mildintegratedmanagesystem.utils" )
@EnableTransactionManagement ()
public class MildIntegratedManageSystemApplication {

    public static void main ( String[] args ) {
        SpringApplication.run( MildIntegratedManageSystemApplication.class, args );
    }

}
