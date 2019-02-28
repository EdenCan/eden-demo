package com.eden.tomcat;

import com.eden.http.Request;
import com.eden.http.Response;
import com.eden.servlet.EdenServlet;

import java.io.OutputStream;
import java.net.Socket;

public class SocketProcess extends Thread{

    protected Socket socket;

    public SocketProcess(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Request request = new Request(socket.getInputStream());
            Response response = new Response(socket.getOutputStream());

            EdenServlet servlet = EdenTomcat.servletMapping.get(request.getUrl());

            if (servlet != null) {
               servlet.service(request,response);
            }else{
                String res = Response.responseHeader+"Hello World, My name is Eden";
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(res.getBytes());
                outputStream.flush();
                outputStream.close();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}