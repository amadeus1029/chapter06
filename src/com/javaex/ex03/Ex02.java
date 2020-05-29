package com.javaex.ex03;

import java.io.*;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String str = br.readLine();

        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);

        bw.write(str);

        br.close();
        bw.close();
    }
}
