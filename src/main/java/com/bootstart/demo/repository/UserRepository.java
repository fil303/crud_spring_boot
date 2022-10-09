package com.bootstart.demo.repository;

import com.bootstart.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends CrudRepository<User,Integer> {
    public User findById(int id);
    public User findByEmail(String email);
}
