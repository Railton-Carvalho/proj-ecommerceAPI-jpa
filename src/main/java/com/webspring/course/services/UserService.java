package com.webspring.course.services;

import com.webspring.course.entities.User;
import com.webspring.course.repositories.UserRepository;
import com.webspring.course.services.exceptions.DatabaseException;
import com.webspring.course.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User insert(User obj){
        return repository.save(obj);
    }
    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }

    }
    public User update(Long id, User user){
        User entity = repository.getReferenceById(id);
        updateData(entity, user);
        return repository.save(entity);
    }
    public void updateData(User entity, User user){
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
