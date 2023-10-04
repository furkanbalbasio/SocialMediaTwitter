package org.example.service;

import org.example.repository.TweetRepository;
import org.example.repository.entity.Tweet;
import java.util.List;
import java.util.Optional;

public class TweetService {
    TweetRepository tweetRepository;

    public TweetService() {
        this.tweetRepository = new TweetRepository();
    }

    public Tweet save(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    public void update(Tweet tweet) {
        tweetRepository.update(tweet);
    }

    public List<Tweet> findAll() {
        return tweetRepository.findAll();
    }

    public Optional<Tweet> findById(Long id) {
        return tweetRepository.findById(id);
    }


    public List<Tweet> saveAll(List<Tweet> tweetList){
        return (List<Tweet>) tweetRepository.saveAll(tweetList);
    }

    public void delete(Tweet tweet){
        tweetRepository.delete(tweet);
    }

    public void deleteById(Long id){
        tweetRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return tweetRepository.existById(id);
    }
    public List<Tweet> findByEntity(Tweet tweet){
        return tweetRepository.findByEntity(tweet);
    }

    public List<Tweet> findByColumnNameAndValue(String columnName, String columnValue){
        return tweetRepository.findByColumnNameAndValue(columnName,columnValue);
    }
}
