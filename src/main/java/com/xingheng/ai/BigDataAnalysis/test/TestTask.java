package com.xingheng.ai.BigDataAnalysis.test;


import com.xingheng.ai.BigDataAnalysis.utils.DownloadFilePool;
import com.xingheng.ai.BigDataAnalysis.utils.Httputil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: lym
 * @Date:2019/1/28 14 45
 * @Description:
 */

@Component // 会被启动类里面的 EnableScheduling注解扫描
public class TestTask {



//	@Scheduled(fixedRate = 2000)   // 每隔2秒 输出当前时间
//	@Scheduled(cron = "* * * * * *") //每秒执行一次
//	@Scheduled(fixedRateString = "1000")  //字符串参数，可以实现配置参数
//	public void sum() throws InterruptedException{
//		Thread.sleep(1000L);
//		System.out.println("当前时间："+ new Date());
//	}

    public static void main(String[] args) {
        Date startDate = new Date();

        DownloadFilePool pool = new DownloadFilePool("http://mirror.bit.edu.cn/apache/spark/spark-2.4.3/spark-2.4.3-bin-hadoop2.7.tgz", null, 100);
        pool.getFile();

        long old = 0;
        long now = 0;
        while( Httputil.sum >= Httputil.start ) {
            now = Httputil.start - old;
            old = Httputil.start;

            if(Httputil.sum == Httputil.start) {
                long t = new Date().getTime() - startDate.getTime();
                double speed = ((double)Httputil.sum / (t/1000.0))/1024.0/1024.0;

                System.out.println( "下载完成，用时：" + t/1000.0 +" s 平均网速：" + speed +" M/s" );
                break;
            }

            System.out.println( "网速：" + ((double)(now/0.5))/1024.0/1024.0 +" M/s,已完成：" + (Httputil.start / (double)Httputil.sum)*100 +"%" );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
