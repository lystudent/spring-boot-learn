package com.xingheng.ai.BigDataAnalysis.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 服务器配置类
 *
 * @author: lym
 * @Date:2019/1/11 14 27
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "test")   // 加入prefix = "test" 就不需要@Value("${appname}")
@PropertySource({"classpath:application.properties"})  //加载配置文件

public class ServerSettings {


	//名称
//	@Value("${appname}")
	private String name;

	//域名地址
//	@Value("${domain}")
	private String domain;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}


}
