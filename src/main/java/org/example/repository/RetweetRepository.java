package org.example.repository;

import org.example.repository.entity.Retweet;
import org.example.repository.entity.User;
import org.example.utility.MyFactoryRepository;

public class RetweetRepository extends MyFactoryRepository<Retweet,Long> {
    public RetweetRepository() {
        super(new Retweet());
    }
}
