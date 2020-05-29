package com.javaex.ex03;

import java.io.*;

public class ex01 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("/Users/apolion/Downloads/MS949.txt");
        InputStreamReader isr = new InputStreamReader(is,"MS949");
        BufferedReader br = new BufferedReader(isr);

        while(true) {
            String str = br.readLine();
            if(str == null) {
                System.out.println("끝");
                break;
            }
            System.out.println(str);
        }

        br.close();
    }
}
