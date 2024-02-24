package com.webspring.course.services;

import com.webspring.course.entities.Category;
import com.webspring.course.entities.Order;
import com.webspring.course.repositories.CategoryRepository;
import com.webspring.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }
    public Category findById(Long id){
        Optional<Category> obj =  repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
