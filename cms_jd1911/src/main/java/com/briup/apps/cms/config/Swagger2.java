/**
 * Project Name:poll
 * File Name:Swagger2.java
 * Package Name:com.briup.apps.poll.config
 * Date:2018年6月10日下午6:22:51
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.briup.apps.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ClassName:Swagger2 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年11月12日 下午6:22:51 <br/>
 * @author   nc
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */

@Configuration //表示是配置类，要被加载
@EnableSwagger2 //swagger的配置
public class Swagger2 {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.briup.apps.cms.web.controller"))
																//添加ApiOperiation注解的被扫描
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("人间四月天的水中月的资讯管理平台")
				.description("人间四月天的水中月CSDN博客个人空间,https://me.csdn.net/m0_45237843")
				.termsOfServiceUrl("https://me.csdn.net/m0_45237843")
				.version("1.0")
				.build();
	}
}

