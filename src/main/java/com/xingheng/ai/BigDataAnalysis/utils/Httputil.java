package com.xingheng.ai.BigDataAnalysis.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Classname Httputil 下载类
 * @Description TODO
 * @Date 2019/6/27 4:19 PM
 * @Created by liuyanming
 */
public class Httputil {

    /**
     * 记录读取了多少，一共读取了多少
     */
    public static long start;

    /**
     * 记录文件总大小
     */
    public static long sum;

    /**
     * @Description: 获取 url 连接
     * @param urlLocation
     * @return  HttpURLConnection实例化对象
     * @throws IOException
     */
    public static HttpURLConnection getHttpConnection (String urlLocation) throws IOException {

        URL url = new URL(urlLocation);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        return conn;
    }




}
