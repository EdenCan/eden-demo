package com.eden.servlet;

import com.eden.http.Request;
import com.eden.http.Response;

import java.io.OutputStream;

/**
 * 模拟应用包
 */
public class LoginServlet extends EdenServlet {
    @Override
    public void doGet(Request request, Response response) {
        this.doPost(request,response);
    }

    @Override
    public void doPost(Request request, Response response)  {
        try {
            OutputStream outputStream = response.outputStream;
            String res = Response.responseHeader+"Hello,welcome to here !";
            outputStream.write(res.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}