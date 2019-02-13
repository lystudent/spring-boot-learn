package com.xingheng.ai.BigDataAnalysis.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 点对点消费
 * @ClassName OrderConsumer
 * @Description TODO
 * @Author liuyanming
 * @Date 2019/2/12 4:35 PM
 */

@Component
public class OrderConsumer {


    @JmsListener(destination = "order.queue")  //建立链接，监听 "order.queue" 队列
    public void receiveQueue(String text){
        System.out.println("OrderConsumer收到的报文为："+text);

    }
}
