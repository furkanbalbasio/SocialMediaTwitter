package org.example;

import org.example.controller.CommentController;
import org.example.controller.RetweetController;
import org.example.controller.TweetController;
import org.example.controller.UserController;
import org.example.service.TweetService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean close=false;
        do{
            int secim=0;
            login();
            System.out.println("Lutfen seciniz......");
            secim=new Scanner(System.in).nextInt();
            switch (secim){
                case 0: close=true; break;
                case 1: UserController.registerUser(); break;
                case 2: UserController.loginUser();
                secimYap();
                break;
            }
        }while (!close);
    }
    private static void login(){
        System.out.println("*************************************");
        System.out.println("*********    SOSYAL MEDYA   *********");
        System.out.println("*************************************");
        System.out.println();
        System.out.println("1-Uye Ol");
        System.out.println("2-Giris Yap");
        System.out.println("0-Kapat");
    }
    private static void secimYapMenu(){
        System.out.println("*************************************");
        System.out.println("*********        AKIS       *********");
        System.out.println("*************************************");
        System.out.println();
        System.out.println("1-Tweet Gir");
        System.out.println("2-Comment Gir ");
        System.out.println("3-Retweet Et");
        System.out.println("0-Cikis yap");
    }
    private static void secimYap(){

        boolean close=false;
        do{
            int secim=0;
            secimYapMenu();
            System.out.println("Lutfen seciniz......");
            secim=new Scanner(System.in).nextInt();
            switch (secim){
                case 0: close=true; break;
                case 1: TweetController.tweetAt(); break;
                case 2: CommentController.commentAt(); break;
                case 3: RetweetController.retweetAt(); break;
            }
        }while (!close);
        menu();
    }
    private static void menu(){
        boolean close=false;
        do {
            home();
            System.out.println("Lutfen seciniz...");
            int secim=new Scanner(System.in).nextInt();
            switch (secim){
                case 0: close=true; break;
                case 1: UserController.findByUsername();
                break;
                case 2:
                    UserController.userList(); break;
                case 3:
                    TweetController.findByTweet(); break;
                case 4:
                    CommentController.findByComment(); break;
                case 5:
                    RetweetController.findByRetweet();break;
            }
        }while (!close);
    }
    private static void home(){
        System.out.println("*************************************");
        System.out.println("*********        AKIS       *********");
        System.out.println("*************************************");
        System.out.println();
        System.out.println("1-Kullanici Ara");
        System.out.println("2-Kullanici Listele");
        System.out.println("3-Tweetleri Gor");
        System.out.println("4-Commentleri Gor");
        System.out.println("5-Retweetleri Gor");
        System.out.println("0-Cıkıs Yap");
    }
}