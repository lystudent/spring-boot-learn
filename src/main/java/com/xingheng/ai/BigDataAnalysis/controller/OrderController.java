package com.xingheng.ai.BigDataAnalysis.controller;

import com.xingheng.ai.BigDataAnalysis.domain.JsonData;
import com.xingheng.ai.BigDataAnalysis.service.ProducerService;
import javafx.beans.binding.ObjectExpression;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.jms.Destination;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author liuyanming
 * @Date 2019/2/12 3:07 PM
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private ProducerService producerService;


    /**
     * 功能描述：微信支付回调接口
     * @param msg  支付信息
     * @return
     */
    @GetMapping("order")
    public Object order(String msg){
        Destination destination = new ActiveMQQueue("order.queue");
        producerService.sendMessage(destination,msg);
        return JsonData.buildSuccess();
    }

    /**
     * 功能描述：评论信息回调接口
     * @param msg
     * @return
     */
    @GetMapping("common")
    public Object common(String msg){
        producerService.sendMessage(msg);
        return  JsonData.buildSuccess();
    }


    @GetMapping("topic")
    public Object topic(String msg){
        producerService.publish(msg);
        return JsonData.buildSuccess();
    }
}
