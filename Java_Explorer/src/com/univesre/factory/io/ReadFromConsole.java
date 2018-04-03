package factory.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromConsole {

    public static void main(String args[]) throws IOException {
        // 从控制台读取字符流(System.in), 可以用BufferedReader这个'封装集合';
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text and 'end' to quit:");
        do {
            str = in.readLine();
            System.out.println(str);
        } while (!str.equals("end"));

    }

}
