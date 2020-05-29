package com.javaex.ex02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        Writer fw = new FileWriter("/Users/apolion/Downloads/song.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("학교종이 땡땡땡");
        bw.newLine();
        bw.write("캬악 퉷");
        bw.newLine();
        bw.write("두두둥장");
        bw.newLine();
        bw.write("학교종이 땡땡땡");
        bw.newLine();
        bw.write("캬악 퉷");
        bw.newLine();
        bw.write("두두둥장");

        bw.close();
    }
}
