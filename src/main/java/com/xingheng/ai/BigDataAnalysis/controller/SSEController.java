package com.xingheng.ai.BigDataAnalysis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.ServerEndpoint;

/**
 * @ClassName SSEController
 * @Description TODO
 * @Author liuyanming
 * @Date 2019/2/14 2:50 PM
 */
@RestController
@RequestMapping("/sse")
public class SSEController {


//    @RequestMapping(value = "/get_data",produces = "text/event-stream;charset=UTF-8")
//    public String push(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "data:xdclass 行情"+ Math.random()+"\n\n" ;
//    }
}
