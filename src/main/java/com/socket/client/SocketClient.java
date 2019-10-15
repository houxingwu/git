package com.socket.client;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @Description Socket的demo
 * @Author
 * @Date 2019-09-29 16:40
 * @Version 1.0
 */
public class SocketClient {
    public static void main(String[] args) {
        try {
            // 和服务器创建连接
            Socket socket = new Socket("localhost",8088);

            // 要发送给服务器的信息
            SocketAddress localSocketAddress = socket.getLocalSocketAddress();
            System.out.println(localSocketAddress);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("客户端发送信息");
            pw.flush();

            socket.shutdownOutput();

            // 从服务器接收的信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("我是客户端，服务器返回信息："+info);
            }

            br.close();
            is.close();
            os.close();
            pw.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
