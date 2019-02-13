package com.xingheng.ai.BigDataAnalysis.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息订阅
 * @ClassName TopicComsumer
 * @Description TODO
 * @Author liuyanming
 * @Date 2019/2/12 5:05 PM
 */
@Component
public class TopicSub {

    @JmsListener(destination = "video.topic",containerFactory="jmsListenerContainerTopic")
    public void receiveQueue1(String text){
        System.out.println("video.topic 消费者 收到的receive1为："+text);
    }


    @JmsListener(destination = "video.topic",containerFactory="jmsListenerContainerTopic")
    public void receiveQueue2(String text){
        System.out.println("video.topic 消费者 收到的receive2为："+text);
    }


    @JmsListener(destination = "video.topic")
    public void receiveQueue3(String text){
        System.out.println("video.topic 消费者 收到的receive3为："+text);
    }


}
