package com.xingheng.ai.BigDataAnalysis.utils;

import javax.rmi.CORBA.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;

/**
 * @Classname DownloadFileRang  文件下载类，此处使用 继承 Runnable 实现多线程
 * @Description TODO
 * @Date 2019/6/27 6:24 PM
 * @Created by liuyanming
 */
public class DownloadFileRang implements Runnable{


    /**
     * 文件开始位置
     */
    private long start;

    /**
     * 文件结束位置
     */
    private long end;

    /**
     * 设置获取资源范围
     */
    private String url_location;


    /**
     * 文件存储位置
     */
    private String file_path ;


    public DownloadFileRang(long start,long end,String url_location,String file_path){
        super();
        this.start = start;
        this.end = end;
        this.url_location = url_location;
        this.file_path = file_path;
    }

    @Override
    public void run() {
        try {
            /**
             * 获取连接
             */
            HttpURLConnection conn = Httputil.getHttpConnection(url_location);

            File file = new File(file_path);
            RandomAccessFile out = null;
            if(file!=null){
                out = new RandomAccessFile(file,"rw");
            }
            out.seek(start);

            /**
             * 获取网络连接的输入流
             */

            InputStream is = conn.getInputStream();

            byte [] data = new byte[1024];

            int len = 0;

            while ((len = is.read(data))!=-1){
                out.write(data,0,len);
                synchronized (Httputil.class){
                    Httputil.start+=len;
                }
            }

            /**
             * 关闭连接诶
             */
            out.close();
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
