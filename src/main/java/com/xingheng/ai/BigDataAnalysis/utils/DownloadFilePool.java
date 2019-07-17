package com.xingheng.ai.BigDataAnalysis.utils;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname DownloadFilePool 文件切片，分别指定 起始点，注意这里的起始点是包头也包尾的
 * @Description TODO
 * @Date 2019/6/27 4:26 PM
 * @Created by liuyanming
 */
public class DownloadFilePool {


    /**
     * 网络资源路径
     */
    private String url_location;

    /**
     * 数据存储路径
     */
    private String file_path;

    /**
     * 多少个线程
     */
    private int pool_length;


    public DownloadFilePool(String url_location, String file_path, int pool_length) {
        super();
        /**
         * 如果 保存路径为空则默认存在 D盘，文件名跟下载名相同
         */
        if (null == file_path) {
            String file_name = url_location.substring(url_location.lastIndexOf("/") + 1);
            file_path = "/Users/liuyanming/data/" + file_name;
        }
        this.url_location = url_location;
        this.file_path = file_path;
        this.pool_length = pool_length;
    }

    public void getFile() {

        try {
            /**
             * 获取文件长度
             */
            long file_length = Httputil.getHttpConnection(url_location).getContentLength();
            Httputil.sum = file_length;
            ExecutorService pool = Executors.newCachedThreadPool();

            long slice = file_length / pool_length;

            for (int i = 0; i < pool_length; i++) {
                long start = i * slice;
                long end = (i + 1) * slice - 1;

                if (i == pool_length - 1) {
                    start = i * slice;
                    end = file_length;
                }
                System.out.println(start + "---" + end);
                //创建下载类
                DownloadFileRang downloadFileRang = new DownloadFileRang(start, end, url_location, file_path);
                //执行线程
                pool.execute(downloadFileRang);

            }
            // 关闭线程池
            pool.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
