package com.demo.testapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2).groupName("Public-API")
	          .apiInfo(apiInfo())
	          .select()                                  
	          .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }
	 
	 private ApiInfo apiInfo() {
	       return new ApiInfoBuilder().title("Demo Rest API")
	    		   .description("To show how rest api works using Spring Boot")
	    		   .version("1.0")
	    		   .termsOfServiceUrl("Demo")
	    		   .license("Developed by Janani Velmurugan")
	    		   .build();
	    		   

	    }
	}

