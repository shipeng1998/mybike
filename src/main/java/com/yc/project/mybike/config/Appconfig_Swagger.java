package com.yc.project.mybike.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
@EnableSwagger2   //启用swagger
public class Appconfig_Swagger {
	
	@Value(value="${swagger.enabled}")   //配置信息中的swagger
	Boolean swaggerEnabled;
	
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.enable(swaggerEnabled).select()
				.apis(RequestHandlerSelectors.basePackage("com.yc")) // 扫描的路径包,只要这些包中的类配有swagger注解，则启用这些注解
				.paths(PathSelectors.any()).build().pathMapping("/"); // 指定路径处理PathSelectors.any()代表所有的路径
				
				
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("共享单车操作接口").description("springboot | swagger")
				.contact(new Contact("sp", "http://www.baidu.com", "1232324"))
				.version("1.1")
				.build();
	}

}
