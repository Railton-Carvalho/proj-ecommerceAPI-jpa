package com.webspring.course.services;

import com.webspring.course.entities.OrderItem;
import com.webspring.course.repositories.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService implements Serializable {

    private OrderItemRepository repository;

    public OrderItemService(OrderItemRepository repository){
        this.repository = repository;
    }
    public List<OrderItem> findAll(){
        return repository.findAll();
    }
    public OrderItem findById(Long id){
        Optional<OrderItem> obj =  repository.findById(id);
        return obj.get();
    }
}
