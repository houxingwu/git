package com.socket.tcp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description 服务方
 * @Author
 * @Date 2019-10-14 23:19
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(10086);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("写入图片到.JPG");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes, 0, len);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
