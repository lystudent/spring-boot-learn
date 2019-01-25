package com.xingheng.ai.BigDataAnalysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import javax.servlet.MultipartConfigElement;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目启动类
 */
//@SpringBootApplication = @SpringBootConfiguration+@EnableAutoConfiguration+@ComponentScan
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.xingheng.ai.BigDataAnalysis.mapper")  // 扫描对应的mapper文件
public class BigDataAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigDataAnalysisApplication.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();

		// 单个文件最大
		factory.setMaxFileSize("1024KB");
		//设置总上传文件大小
		factory.setMaxRequestSize("10240000KB");
		return factory.createMultipartConfig();
	}
}

