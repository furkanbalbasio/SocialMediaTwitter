package org.example.controller;

import org.example.repository.entity.Comment;
import org.example.repository.entity.Tweet;
import org.example.repository.entity.User;
import org.example.service.CommentService;
import org.example.service.TweetService;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class CommentController {
    static CriteriaBuilder criteriaBuilder;
    static EntityManager entityManager;
    public static void findByComment(){
        new TweetService().findAll().forEach(System.out::println);
        System.out.print("Yorumlarini gormek istediginiz tweetin id'sini giriniz.");
        Long tweetId=new Scanner(System.in).nextLong();
     new CommentService().findById(tweetId).stream().forEach(System.out::println);
    }
    public static void commentAt(){
        System.out.println("Gondermek istediginiz yorumu yaziniz");
        String atilanComment=new Scanner(System.in).nextLine();
        TweetController.findByTweet();
        System.out.println("Yorum atacaginiz tweeetin id sini giriniz.");
        Integer secilenTweet=new Scanner(System.in).nextInt();
        Long secilenId=Long.valueOf(secilenTweet);
        Comment comment=Comment.builder()
                .comment(atilanComment)
                .date(LocalDate.of(2023,01,01))
                .tweetid(secilenId)
                .userid(findUserById())
                .build();
        new CommentService().save(comment);
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
