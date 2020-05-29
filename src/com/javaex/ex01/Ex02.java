package com.javaex.ex01;

import java.io.*;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("/Users/apolion/Downloads/img.jpg");
        BufferedInputStream buffIn = new BufferedInputStream(in);
        OutputStream out = new FileOutputStream("/Users/apolion/Downloads/bytebuff.jpg");
        BufferedOutputStream buffOut = new BufferedOutputStream(out);

        while(true) {
            int data = buffIn.read();
            if(data == -1) {
                System.out.println("흡입종료");
                break;
            }
            buffOut.write(data);
        }

        out.close();
        in.close();
    }
}
