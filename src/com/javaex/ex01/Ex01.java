package com.javaex.ex01;

import java.io.*;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("/Users/apolion/Downloads/img.jpg");
        OutputStream out = new FileOutputStream("/Users/apolion/Downloads/byte2.jpg");

        byte[] buff = new byte[1024];

        System.out.println("흡입 스타트");
        while(true) {
            int data = in.read(buff);
            if(data == -1) {
                System.out.println("흡입 종료 ㅋㅋㅋ"+data);
                break;
            }
            out.write(buff);
        }

        out.close();
        in.close();
    }
}
