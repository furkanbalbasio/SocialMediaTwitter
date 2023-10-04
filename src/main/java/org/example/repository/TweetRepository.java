package org.example.repository;

import org.example.repository.entity.Tweet;
import org.example.repository.entity.User;
import org.example.utility.MyFactoryRepository;

public class TweetRepository extends MyFactoryRepository<Tweet,Long> {
    public TweetRepository() {
        super(new Tweet());
    }
}
