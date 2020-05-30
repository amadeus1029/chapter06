package com.javaex.ex04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonApp {

    public static void main(String[] args) throws IOException {
        //ArrayList 생성 후 파일로부터 리스트 내부 객체 삽입
        List<Person> personList = new ArrayList<Person>();
        readList(personList);

        //입력받을 준비
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        //시스템 시작 - 텍스트파일은 프로그램 종료 후 변경되도록 설정
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
                    showList(personList);
                    break;
                case "2":
                    System.out.println("이름, 핸드폰번호, 회사번호의 형태로 입력해주세요");
                    String add = br.readLine();
                    addPerson(personList, add);
                    System.out.println("입력을 완료하였습니다");
                    break;
                case "3":
                    showList(personList);
                    System.out.println("삭제할 번호를 입력해주세요");
                    String order = br.readLine();
                    removePerson(personList, order);
                    System.out.println("삭제를 완료하였습니다");
                    break;
                case "4":
                    menuEnd = true;
                    writeList(personList);
                    System.out.println("시스템을 종료합니다");
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다");
                    break;
            }
        } while (!menuEnd);

        br.close();
    }

    //프로그램 가동 시에 리스트 읽어오는 초기화 메소드
    public static void readList(List<Person> list) throws IOException {
        InputStream input = new FileInputStream("/Users/apolion/Downloads/PhoneDB.txt");
        InputStreamReader inputReader = new InputStreamReader(input, "UTF-8");
        BufferedReader buffR = new BufferedReader(inputReader);

        while (true) {
            String infoString = buffR.readLine();
            if (infoString == null) {
                break;
            }
            addPerson(list, infoString);
        }

        buffR.close();
    }

    //목록 호출 메소드
    public static void showList(List<Person> list) {
        int i = 1;
        for (Person p : list) {
            System.out.println(i + ".");
            p.showInfo();
            i++;
        }
    }

    //인물 추가 메소드
    public static void addPerson(List<Person> list, String str) {
        String[] infoArray = str.split(",");
        String name = infoArray[0].trim();
        String mobile = infoArray[1].trim();
        String company = infoArray[2].trim();
        list.add(new Person(name, mobile, company));
    }

    //인물 삭제 메소드
    public static void removePerson(List<Person> list, String str) {
        int intOrder = Integer.parseInt(str);
        list.remove(intOrder - 1);
    }

    //시스템 종료시에 텍스트 파일 변경 메소드
    public static void writeList(List<Person> list) throws IOException {
        OutputStream target = new FileOutputStream("/Users/apolion/Downloads/PhoneDB.txt");
        OutputStreamWriter ow = new OutputStreamWriter(target, "UTF-8");
        BufferedWriter bw = new BufferedWriter(ow);

        for (Person p : list) {
            bw.write(p.toString());
        }
        bw.close();
    }
}
