package org.example.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_retweet")
public class Retweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long tweetid;
    Long userid;
    @Builder.Default
    private LocalDate date = LocalDate.now();}
