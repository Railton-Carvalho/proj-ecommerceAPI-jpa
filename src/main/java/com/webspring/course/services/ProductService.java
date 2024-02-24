package com.webspring.course.services;

import com.webspring.course.entities.Order;
import com.webspring.course.entities.Product;
import com.webspring.course.repositories.ProductRepository;
import com.webspring.course.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository repository;

    public  ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }
    public Product findById(Long id){
        Optional<Product> obj =  repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
