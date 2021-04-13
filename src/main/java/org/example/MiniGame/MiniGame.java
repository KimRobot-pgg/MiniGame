package org.example.MiniGame;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class MiniGame {
    public static void main(String[] args) {

        String gameNum;
        do {
            System.out.println("*************");
            System.out.println("* mini games List");
            System.out.println("* 1. 가위바위보");
            System.out.println("* 2. 메이플스토리");
            System.out.println("* 0. 종료");
            System.out.println("*************");
            System.out.print("* 게임을 선택하세요 : ");
            gameNum = MiniGame.nextLine(); //문자 입력

            switch (gameNum) {
                case "1":
                case "가위바위보":
                    MiniGame.cls(); //출력물 간격 띄우기
                    System.out.println("가위바위보 선택!");
                    rspGame(); //게임 메소드 실행
                    break;
                case "2":
                case "메이플스토리":
                    MiniGame.cls();
                    System.out.println("2번 게임 선택");

                    break;
                case "0":
                case "종료":
                    System.out.println("종료 실행");
                    break;
                default:
                    MiniGame.cls();
                    System.out.println("다시 입력해주세요");
                    break;
            }
            System.out.println("gameNum 결과 확인: " + gameNum);
            boolean a = gameNum.equals("1");
            System.out.println("1을 입력했을때 true: " + a);
            System.out.println("!a: " + !a);
            boolean b = !gameNum.equals("1");
            System.out.println("!gameNum.equals(\"1\"): " + b);
            boolean c = gameNum.equals("0");
            System.out.println("gameNum.equals(\"0\"): " + c);
            boolean d = !gameNum.equals("0");
            System.out.println("!gameNum.equals(\"0\"): " + d);

        } while (!(gameNum.equals("0") || gameNum.equals("종료")));
        // while (!gameNum.equals("0") || !gameNum.equals("종료")); <- 탈출불가.

        MiniGame.cls();
        System.out.println("프로그램 종료~ ㅂㅂ~ ");
    }

    //가위바위보 게임
    public static void rspGame() {
        Random random = new Random();
        HashMap<Integer, String> map1;
        map1 = new HashMap<>();
        map1.put(1, "가위");
        map1.put(2, "바위");
        map1.put(3, "보");

        while (true) {
            System.out.println("1.가위 2.바위 3.보 4.게임끝내기");
            System.out.print(">입력 : ");
            int you = MiniGame.nextInt();  //무엇을 낼지 결정

            switch (you) {
                case 1:
                case 2:
                case 3:
                case 4:  // java11에서는 향상된 switch 문 못씀
                    break;
                default:
                    System.out.println("선택 이탈! 다시 선택하세요");
                    continue;
            }

            if (you == 4)  // 프로그램 종료
                break;

            int com = random.nextInt(3) + 1;  //1~3 까지 랜덤 생성.

            System.out.println("당신 : " + map1.get(you));
            System.out.println("컴퓨터 : " + map1.get(com));

            int result = you - com;
            if (result == 0) {
                System.out.println("** 무승부 **");
            } else if (result == -1 || result == 2) {
                System.out.println("당신이 졌습니다.");
            } else {
                System.out.println("당신이 이겼습니다.");
            }
        }
        System.out.println("--- 가위바위보 게임 종료 --- ");
    }

    public static void mapleStory() {

    }

    // 콘솔 공백출력
    public static void cls() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    //콘솔입력 메소드
    public static int nextInt() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static String nextLine() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}

class MaplePlayer {
    String playerName;

    int job;
    int[] ability = {0,0,0,0};
    int hp = 100;
    int money = 1000;

    public void getHurts(int a) {
        this.hp -= a;
    }
}

class MapleMonster {
    String monsterName;
    int hp = 100;
    int[] item = {};

    public void getHurts(int a) {
        this.hp -= a;
    }
}
