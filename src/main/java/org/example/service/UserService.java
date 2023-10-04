package org.example.service;

import org.example.repository.UserRepository;
import org.example.repository.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    public List<User> saveAll(List<User> userList){
        return (List<User>) userRepository.saveAll(userList);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return userRepository.existById(id);
    }
    public List<User> findByEntity(User user){
        return userRepository.findByEntity(user);
    }

    public List<User> findByColumnNameAndValue(String columnName, String columnValue){
        return userRepository.findByColumnNameAndValue(columnName,columnValue);
    }
}
