package org.example.MiniGame;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class MiniGame {
    public static void main(String[] args) {

        String gameNum;

        do {
            MiniGame.cls();
            System.out.println("******메인 메뉴*******");
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
                    MiniGame.mapleStory();
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

        } while (!(gameNum.equals("0") || gameNum.equals("종료")));

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
            MiniGame.cls();
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
        MiniGame.cls();
    }

    //메이플스토리
    public static void mapleStory() {
        MaplePlayer p1 = new MaplePlayer();
        Mushroom a = new Mushroom();
        System.out.println(a.art);

        while(true) {
            System.out.println("> 모험을 떠나볼까요?");
            System.out.println(">1.입장하기");
            System.out.println(">2.나가기");
            System.out.print("숫자입력: ");
            int menu = MiniGame.nextInt();

            if (menu == 1) {
                MiniGame.cls();
                System.out.println("플레이어 이름: ");
                p1.playerName = MiniGame.nextLine();

                System.out.println("게임 종료");

            }
            else if (menu == 2) {
                System.out.println("***안녕히 가세요***");
                break;
            }
            else {
                System.out.println("다시 입력해주세요.");
            }
        }
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

    //콘솔 문자열 입력 메소드
    public static String nextLine() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}

class MaplePlayer {
    String playerName = "";
    int hp = 100;
    int money = 1000;

    public void getHurts(int a) {
        this.hp -= a;
    }

}

class MapleMonster {
    String monsterName = "주황버섯";
    int hp = 100;

    public void getHurts(int a) {
        this.hp -= a;
    }
}

class Mushroom {
    String art = "\n" +
            "┏━┳━┓╋╋╋╋╋╋╋╋╋┏━━┳┓\n" +
            "┃┃┃┃┣━┓┏━┳┓┏━┓┃━━┫┗┳━┳┳┳┳┓\n" +
            "┃┃┃┃┃╋┗┫╋┃┗┫┻┫┣━━┃┏┫╋┃┏┫┃┃\n" +
            "┗┻━┻┻━━┫┏┻━┻━┛┗━━┻━┻━┻┛┣┓┃\n" +
            "╋╋╋╋╋╋╋┗┛╋╋╋╋╋╋╋╋╋╋╋╋╋╋┗━┛";
}
