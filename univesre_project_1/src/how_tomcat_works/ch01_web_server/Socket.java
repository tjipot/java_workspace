package how_tomcat_works.ch01_web_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @File: Socket.java
 * @Classname: Socket
 * @Description: TODO
 * @Author: Haoran Ye
 * @CreateDate: 17/9/29 14:48
 * @ModificationHistory: WHAT WHEN WHO
 **/
public class Socket {

    /**
     * @Title: 
     * @Description: TODO
     * @Parameter: 
     * @Return: 
     * @Throws: 
     **/
    public static void main(String[] args) {
        Socket socket = new Socket("127.0.0.1", "8080");
        OutputStream os = socket.getOutputStream();
        boolean autoFlush = true;
        PrintWriter out = new PrintWriter(os, autoFlush);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.println("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connnection: Close");
        out.println();

        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while(loop) {
            if(in.ready()) {
                int i = 0;
                while(i != -1) {
                    i = in.read();
                    sb.append((char)i);
                }
                loop = false;
            }
            Thread.currentThread().sleep(50);
        }
        System.out.println(sb.toString());
        socket.close();
    }


}
