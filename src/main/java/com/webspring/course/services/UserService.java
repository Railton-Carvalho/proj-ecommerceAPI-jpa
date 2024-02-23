package com.webspring.course.services;

import com.webspring.course.entities.User;
import com.webspring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }
    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById(Long id){
        Optional<User> obj =  repository.findById(id);
        return obj.get();
    }
    public User insert(User obj){
        return repository.save(obj);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
