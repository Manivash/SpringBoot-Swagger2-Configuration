package com.manivash;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootSwagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwagger2Application.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.manivash"))
				.build()
				.apiInfo(apiDtails());
	}
	
	private ApiInfo apiDtails() {
		
		return new ApiInfo(
				"Address book API",
				"Sample API for JavaBrains tutorial",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Manivash", "https://google.com", "abc@gmail.com"),
				"API License",
				"https://google.com",
				Collections.emptyList());
	}
}
