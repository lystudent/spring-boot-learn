package com.xingheng.ai.BigDataAnalysis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import static com.google.common.collect.Lists.newArrayList;


/**
 * @author: lym
 * @Date:2019/1/9 10 31
 * @Description:
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.xingheng.ai.BigDataAnalysis.controller"))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(securitySchemes())
				.securityContexts(securityContexts())
				;
	}

	private List<ApiKey> securitySchemes() {
		return newArrayList(
				new ApiKey("Authorization", "Authorization", "header"));
	}
	private List<SecurityContext> securityContexts() {
		return newArrayList(
				SecurityContext.builder()
						.securityReferences(defaultAuth())
						.forPaths(PathSelectors.regex("^(?!auth).*$"))
						.build()
		);
	}
	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return newArrayList(
				new SecurityReference("Authorization", authorizationScopes));
	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder()
				.title("大数据分析平台")
				.description("大数据分析平台接口")
				.version("0.0.1")
				.build();
	}






}
