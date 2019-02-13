package com.xingheng.ai.BigDataAnalysis.service;

import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @ClassName ProducerService
 * @Description TODO
 * @Author liuyanming
 * @Date 2019/2/12 2:30 PM
 */

public interface ProducerService {

    /**
     * 指定消息队列，和消息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination,final String message);

    /**
     * 使用默认消息队列，发送消息
     * @param message
     */
    public void sendMessage(final  String message);


    /**
     * 消息发布者
     * @param msg
     */
    public void publish(String msg);
}
