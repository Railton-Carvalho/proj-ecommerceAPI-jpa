package com.webspring.course.services;

import com.webspring.course.entities.Order;
import com.webspring.course.entities.User;
import com.webspring.course.repositories.OrderRepository;
import com.webspring.course.resources.OrderResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService  {
    private OrderRepository repository;

    public OrderService(OrderRepository repository){
        this.repository = repository;
    }

    public List<Order> findAll(){
        return repository.findAll();
    }
    public Order findById(Long id){
        Optional<Order> obj =  repository.findById(id);
        return obj.get();
    }

}
