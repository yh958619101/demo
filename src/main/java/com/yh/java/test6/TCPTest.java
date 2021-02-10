package com.yh.java.test6;

/**
 * TCP传输图片
 *1.创建TCP服务端，TCP客户端。
 *2.服务端等待客户端连接，客户端连接后，服务端向客户端写入图片。
 *3.客户端收到后进行文件保存。
 *
 *程序分析：
 *1.服务器和客户端的创建,ServerSocket和Socket类的使用
 *2.过OutputStream和InputStream的对对象方法进行数据的写入和读取。
 * */

public class TCPTest {

    public static void main(String[] args) {
        // 开启服务器 ,设定端口号
        TCPServer server = new TCPServer(6508);
        server.start();

        // 开启客户端
        // 需要服务端的正确的IP地址和端口号
        TCPClient client = new TCPClient("192.168.0.12", 6508);
        client.start();
    }

}
