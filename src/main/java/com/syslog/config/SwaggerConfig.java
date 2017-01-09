package com.syslog.config;

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
 * The Class SwaggerConfig.
 * 
 * Swagger Documentation
 * 
 * @Link {http://localhost:8080/swagger-ui.html}
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * News api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(apiInfo()).select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build();
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("Spring REST Service for Syslog Manager")
			.description("Syslog Manager")
			.version("1.0")
			.build();
	}
}