package org.example.controller;

import org.example.repository.entity.Tweet;
import org.example.service.TweetService;


import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import static org.example.utility.Constans.getBaseEntity;

public class TweetController {
    public static void findByTweet(){
        new TweetService().findAll().forEach(System.out::println);
    }
    public static void tweetAt(){
        Random random=new Random();
        Long id=random.nextLong();
        System.out.println("Tweetinizi giriniz.");
        String atilanTweet=new Scanner(System.in).nextLine();
        Tweet tweet=Tweet.builder()
                .tweet(atilanTweet)
                .baseEntity(getBaseEntity())
                .date(LocalDate.of(2023,01,01))
                .retweetCount(0)
                .userid(id)
                .build();
        new TweetService().save(tweet);
    }
}
