package com.xingheng.ai.BigDataAnalysis;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
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
@EnableScheduling  // 开启定时任务
@EnableAsync //开启异步任务
@EnableJms
public class BigDataAnalysisApplication {


	public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
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

    /**
     * 主题对象
     * @return
     */
	@Bean
    public Queue queue(){
	    return  new ActiveMQQueue("common.queues"); // 指定队列名称
    }

    @Bean
    public Topic topic(){
	    return new ActiveMQTopic("video.topic");
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
}
