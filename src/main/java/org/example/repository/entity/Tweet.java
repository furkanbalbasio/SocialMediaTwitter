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
@Table(name = "tbl_tweet")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long userid;
    @Column(length = 140)
    String tweet;
    Integer retweetCount;
    @Builder.Default
    private LocalDate date = LocalDate.now();
    @Embedded
    BaseEntity baseEntity;
}
