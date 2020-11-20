package com.syousui.mildintegratedmanagesystem.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : Swagger3Config.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.confg
 * @createTime : 2020-11-20 19:19:00 星期五
 * @Description : TODO
 */

@Configuration
@EnableOpenApi
public class Swagger3Config {
    @Bean
    public Docket createRestApi ( ) {
        return new Docket( DocumentationType.OAS_30 )
                .apiInfo( apiInfo( ) )
                .select( )
                .apis( RequestHandlerSelectors.withMethodAnnotation( ApiOperation.class ) )
                .paths( PathSelectors.any( ) )
                .build( );
    }

    private ApiInfo apiInfo ( ) {
        return new ApiInfoBuilder( )
                .title( "轻度综合管理系统 API文档" )
                .description( "更多请咨询系统开发者 TouSan." )
                .contact( new Contact( "TouSan", "http://acmaker.vip", "justTouSan@gmail.com" ) )
                .version( "1.0" )
                .build( );
    }
}
