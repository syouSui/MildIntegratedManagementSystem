package com.syousui.mildintegratedmanagesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan ( "com.syousui.mildintegratedmanagesystem.mapper" )
@EnableTransactionManagement ()
public class MildIntegratedManageSystemApplication {

    public static void main ( String[] args ) {
        SpringApplication.run( MildIntegratedManageSystemApplication.class, args );
    }

}
