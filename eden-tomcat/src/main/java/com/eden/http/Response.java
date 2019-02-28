package com.eden.http;

import java.io.IOException;
import java.io.OutputStream;

public class Response {

    public OutputStream outputStream;

    //定义响应头，chrome会校验很强，不加这个头chrome会报错
    public static final String responseHeader="HTTP/1.1 200 \r\n"
            + "Content-Type: text/html\r\n"
            + "\r\n";

    public Response(OutputStream outputStream) throws IOException {
        this.outputStream= outputStream;
    }

}
