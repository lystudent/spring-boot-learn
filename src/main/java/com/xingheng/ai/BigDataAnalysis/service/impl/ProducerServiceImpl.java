package com.xingheng.ai.BigDataAnalysis.service.impl;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;


import com.xingheng.ai.BigDataAnalysis.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProducerServiceImpl
 * @Description TODO
 * @Author liuyanming
 * @Date 2019/2/12 2:36 PM
 */
@Service
public class ProducerServiceImpl  implements ProducerService {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;



    /**
     *  指定消息队列，和消息
     * @param destination  消息队列
     * @param message
     */
    @Override
    public void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    /**
     * 使用默认消息队列，发送消息
     * @param message
     */
    @Override
    public void sendMessage(String message) {
        jmsMessagingTemplate.convertAndSend(this.queue,message);
    }

    @Autowired
    private Topic topic;

    @Override
    public void publish(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }
}
