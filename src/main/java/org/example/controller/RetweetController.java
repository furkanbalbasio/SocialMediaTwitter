package org.example.controller;

import org.example.repository.entity.Retweet;
import org.example.repository.entity.Tweet;
import org.example.repository.entity.User;
import org.example.service.CommentService;
import org.example.service.RetweetService;
import org.example.service.TweetService;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RetweetController {
    static CriteriaBuilder criteriaBuilder;
    static EntityManager entityManager;
    static Integer retweetCount;
    public static void findByRetweet(){
        new TweetService().findAll().forEach(System.out::println);
        System.out.print("Retweetlerini gormek istediginiz tweetin id'sini giriniz.");
        Long tweetId=new Scanner(System.in).nextLong();
        new RetweetService().findById(tweetId).stream().forEach(System.out::println);
    }
    public static void retweetAt(){
        TweetController.findByTweet();
        System.out.println("Retweet atacaginiz tweeetin id sini giriniz.");
        Integer secilenTweet=new Scanner(System.in).nextInt();
        Long secilenId=Long.valueOf(secilenTweet);
         retweetCount=new Tweet().getRetweetCount();
        retweetCount++;
        Retweet retweet=Retweet.builder()
                .date(LocalDate.of(2023,01,01))
                .tweetid(secilenId)
                .userid(findUserById())
                .build();
        new RetweetService().save(retweet);
        System.out.println("Retweet sayisi "+retweetCount);
    }
//    public static Long findTweetById(){
//        CriteriaQuery<Long> criteria=criteriaBuilder.createQuery(Long.class);
//        Root<Tweet> tweetRoot=criteria.from(Tweet.class);
//        criteria.select(tweetRoot.get("id"));
//        Long result= Long.valueOf(entityManager.createQuery(criteria).getSingleResult());
//        return result;
//    }
    public static Long findUserById(){
        CriteriaQuery<Long> criteria=criteriaBuilder.createQuery(Long.class);
        Root<User> userRoot=criteria.from(User.class);
        criteria.select(userRoot.get("id"));
        Long result= Long.valueOf(entityManager.createQuery(criteria).getSingleResult());
        return result;
    }
}
