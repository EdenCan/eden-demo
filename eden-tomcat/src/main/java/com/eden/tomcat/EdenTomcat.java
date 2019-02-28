package com.eden.tomcat;


import com.eden.servlet.EdenServlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

/**
 * tomcat核心类
 */
public class EdenTomcat {
    /**
     * 默认端口号
     */
    private static int port = 8080;

    private static final Properties properties = new Properties();

    public static final HashMap<String, EdenServlet> servletMapping = new HashMap<String, EdenServlet>();


    public EdenTomcat(){
    }

    /**
     * 定义可以修改端口的方法
     * @param port
     */
    public EdenTomcat(int port){
        this.port = port;
    }


    public void start(){
        //初始化配置
        init();

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Tomcat 服务已启动，地址：localhost ,端口：" + port);
            //持续监听
            do {
                Socket socket = serverSocket.accept();
                //处理任务
                Thread thread = new SocketProcess(socket);
                thread.start();

            } while (true);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 初始化配置文件
     */
    private void init() {

        InputStream io = null;
        String basePath;
        try {
            //获取basePath
            basePath = EdenTomcat.class.getResource("/").getPath();
            //解决中文乱码问题
            String basePath_UTF8 = URLDecoder.decode(basePath, "utf-8");
            System.out.println(basePath);
            //读取配置文件中指定的servlet和mapping路径，类似于我们web.xml中指定的DipatcherServlet和mapping-url
            io = new FileInputStream(basePath_UTF8 + "web.properties");
            properties.load(io);
            io.close();

            //初始化ServletMapping
            //返回属性key的集合
            Set<Object> keys = properties.keySet();
            for (Object key : keys) {
                if (key.toString().contains("url")) {
                    System.out.println(key.toString() + "=" + properties.get(key));
                    //根据key值获取className
                    Object classname = properties.get(key.toString().replace("url", "classname"));

                    //获取指定的核心控制器
                    servletMapping.put(properties.get(key.toString()).toString(),
                            (EdenServlet) Class.forName(classname.toString()).newInstance());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (io != null) {
                try {
                    io.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * tomcat启动入口
     * org.apache.catalina.startup.Bootstrap#main
     * @param args
     */
    public static void main(String[] args) {
        new EdenTomcat().start();
    }
}
