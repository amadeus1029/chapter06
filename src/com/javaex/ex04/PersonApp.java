package com.javaex.ex04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonApp {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        List<Person> personList = new ArrayList<Person>();
        readList(personList);

        System.out.println("=============================");
        System.out.println("       전화번호부 시스템      ");
        boolean menuEnd = false;
        do {
            System.out.println("=============================");
            System.out.println("1.목록 확인\t2.번호 추가\t3.번호 삭제\t4.종료");
            System.out.print(">> ");
            String menu = br.readLine();
            switch (menu) {
                case "1":
                    for (Person p : personList) {
                        p.showInfo();
                    }
                    break;
                case "2":
                    System.out.println("이름, 핸드폰번호, 회사번호의 형태로 입력해주세요");
                    String str = br.readLine();
                    String[] infoArray = str.split(",");
                    String name = infoArray[0].trim();
                    String mobile = infoArray[1].trim();
                    String company = infoArray[2].trim();
                    personList.add(new Person(name, mobile, company));
                    writeList(personList);
                    System.out.println("입력을 완료하였습니다");
                    break;
                case "3":
                    System.out.println("삭제할 번호를 입력해주세요");
                    for (int i = 0; i < personList.size(); i++) {
                        System.out.println(i + 1 + "." + personList.get(i).getName());
                    }
                    String order = br.readLine();
                    int intOrder = Integer.parseInt(order);
                    personList.remove(intOrder - 1);
                    writeList(personList);
                    System.out.println("삭제를 완료했습니다");
                    break;
                case "4":
                    menuEnd = true;
                    System.out.println("시스템을 종료합니다");
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다");
                    break;
            }
        } while (!menuEnd);

        br.close();
    }

    public static void writeList(List list) throws IOException {
        ArrayList<Person> pList = (ArrayList) list;

        OutputStream out = new FileOutputStream("/Users/apolion/Downloads/PhoneDB.txt");
        OutputStreamWriter ow = new OutputStreamWriter(out, "UTF-8");
        BufferedWriter bw = new BufferedWriter(ow);

        for (Person p : pList) {
            bw.write(p.toString());
        }
        bw.close();
    }

    public static void readList(List list) throws IOException {
        ArrayList<Person> pList = (ArrayList) list;

        InputStream input = new FileInputStream("/Users/apolion/Downloads/PhoneDB.txt");
        InputStreamReader inputReader = new InputStreamReader(input, "UTF-8");
        BufferedReader buffR = new BufferedReader(inputReader);

        while (true) {
            String infoString = buffR.readLine();
            if (infoString == null) {
                break;
            }
            String[] infoArray = infoString.split(",");
            String name = infoArray[0];
            String mobile = infoArray[1];
            String company = infoArray[2];
            pList.add(new Person(name, mobile, company));
        }

        buffR.close();

    }
}
