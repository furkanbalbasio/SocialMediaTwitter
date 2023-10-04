package org.example.controller;

import org.example.repository.entity.Comment;
import org.example.service.CommentService;
import org.example.service.TweetService;

import java.util.Optional;
import java.util.Scanner;

public class CommentController {
    public static void findByComment(){
        new TweetService().findAll().forEach(System.out::println);
        System.out.print("Yorumlarini gormek istediginiz tweetin id'sini giriniz.");
        Long tweetId=new Scanner(System.in).nextLong();
     new CommentService().findById(tweetId).stream().forEach(System.out::println);
    }
}
