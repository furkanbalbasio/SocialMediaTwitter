package org.example.controller;

import org.example.service.CommentService;
import org.example.service.RetweetService;
import org.example.service.TweetService;

import java.util.Scanner;

public class RetweetController {
    public static void findByRetweet(){
        new TweetService().findAll().forEach(System.out::println);
        System.out.print("Retweetlerini gormek istediginiz tweetin id'sini giriniz.");
        Long tweetId=new Scanner(System.in).nextLong();
        new RetweetService().findById(tweetId).stream().forEach(System.out::println);
    }
}
