package org.example.repository;

import org.example.repository.entity.User;
import org.example.utility.MyFactoryRepository;

public class UserRepository extends MyFactoryRepository<User,Long> {

    public UserRepository() {
        super(new User());
    }
}
