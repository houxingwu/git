package com.socket.tcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description 客服端
 * @Author
 * @Date 2019-10-14 23:32
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("192.168.48.1", 10086);
            OutputStream outputStream = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream("D://1.JPG");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
            fileInputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
