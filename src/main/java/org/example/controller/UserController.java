package org.example.controller;

import org.example.repository.UserRepository;
import org.example.repository.entity.User;
import org.example.service.UserService;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

import static org.example.utility.Constans.getBaseEntity;

public class UserController {
    private static String loginUserName;
    public static void registerUser(){
        System.out.println("*************************************");
        System.out.println("*********    YENI UYE       *********");
        System.out.println("*************************************");
        System.out.println();
        String username="",name="";
        System.out.print("Kullanici adini giriniz....");
        username=new Scanner(System.in).nextLine();
        System.out.print("Ad ve soyadinizi giriniz.....");
        name=new Scanner(System.in).nextLine();
        User user=User.builder()
                .username(username)
                .name(name)
                .photoUrl("")
                .baseEntity(getBaseEntity())
                .build();
        new UserService().save(user);
    }
    public static void loginUser(){
        System.out.println("Kullanici adini giriniz");
        loginUserName=new Scanner(System.in).nextLine();
    }
    public static void userList(){
        System.out.println("*************************************");
        System.out.println("********* KULLANICI LISTESI *********");
        System.out.println("*************************************");
        System.out.println();
        List<User> users=new UserRepository().findAll();
        users.forEach(u->{
            System.out.println("Username :"+u.getUsername());
            System.out.println("Name :"+u.getName());
            System.out.println("*************************************");
        });
    }
    public static void findByUsername(){
        System.out.print("Bulmak istediginiz kullanicinin adini giriniz.");
        String username=new Scanner(System.in).nextLine();
        String columnName="username";
        new UserService().findByColumnNameAndValue(columnName,username).forEach(System.out::println);
    }


}
