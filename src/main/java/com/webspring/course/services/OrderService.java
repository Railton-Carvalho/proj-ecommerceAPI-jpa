package com.webspring.course.services;

import com.webspring.course.entities.Order;
import com.webspring.course.entities.User;
import com.webspring.course.repositories.OrderRepository;
import com.webspring.course.resources.OrderResource;
import com.webspring.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete( Long id){
        repository.deleteById(id);
    }
    @PutMapping
    public Order updateData(Long id, Order order){
        Order entity = repository.getReferenceById(id);
        updateData(entity, order);
        return repository.save(entity);
    }
    public void updateData(Order entity, Order obj){
        entity.setOrderStatus(obj.getOrderStatus());

    }
}
