package com.sound.writer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
// @ComponentScan(basePackages = { "com.sound.writer" })
public class Swagger2Configure {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(createCustomRestApi()).select()
				.apis(RequestHandlerSelectors.basePackage("com.sound.writer")).paths(PathSelectors.any()).build();
	}

	private ApiInfo createCustomRestApi() {
		/*
		 * return new ApiInfoBuilder()
		 * .title("Spring Boot中使用Swagger2构建RESTful APIs")
		 * .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
		 * .termsOfServiceUrl("http://blog.didispace.com/") .contact("程序猿DD")
		 * .version("1.0") .build();
		 */
		ApiInfo apiInfo = new ApiInfo("作文家应用", // 大标题
				"后台API手册", // 小标题
				"1.0", // 版本
				"NO terms of service", "2519151032@qq.com", // 作者
				"The Apache License, Version 2.0", // 链接显示文字
				"http://www.apache.org/licenses/LICENSE-2.0.html"// 网站链接
		);
		return apiInfo;
	}

}
