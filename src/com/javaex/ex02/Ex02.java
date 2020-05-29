package com.javaex.ex02;

import java.io.*;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        Reader fileReader = new FileReader("/Users/apolion/Downloads/MS949.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while(true) {
            String str = bufferedReader.readLine();
            if(str == null) {
                break;
            }
            System.out.println(str);
        }

        bufferedReader.close();
    }
}
