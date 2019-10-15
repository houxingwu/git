package com.socket.udp.revcieve;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Description 接收方
 * @Author
 * @Date 2019-10-13 23:20
 * @Version 1.0
 */
public class Recieve {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(10086);
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket;
            datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            InetAddress address = datagramPacket.getAddress();
            System.out.println(address);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
