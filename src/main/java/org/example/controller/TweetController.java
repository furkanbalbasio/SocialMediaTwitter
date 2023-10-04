package org.example.controller;

import org.example.service.TweetService;

import java.util.Scanner;

public class TweetController {
    public static void findByTweet(){
        new TweetService().findAll().forEach(System.out::println);
    }
}
