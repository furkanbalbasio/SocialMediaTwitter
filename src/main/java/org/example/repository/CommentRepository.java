package org.example.repository;

import org.example.repository.entity.Comment;
import org.example.repository.entity.User;
import org.example.utility.MyFactoryRepository;

public class CommentRepository extends MyFactoryRepository<Comment,Long> {
    public CommentRepository() {
        super(new Comment());
    }
}
