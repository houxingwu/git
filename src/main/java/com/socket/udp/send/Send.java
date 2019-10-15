package com.socket.udp.send;

import org.apache.tomcat.jni.Address;

import javax.xml.ws.soap.Addressing;
import java.io.IOException;
import java.net.*;

/**
 * @Description 发送方
 * @Author
 * @Date 2019-10-13 23:28
 * @Version 1.0
 */
public class Send {
    public static void main(String[] args) throws SocketException {
            byte[] bytes = "houxingwu".getBytes();
            DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket localhost= null;
        try {
            localhost = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 10086);
            datagramSocket.send(localhost);
            datagramSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
