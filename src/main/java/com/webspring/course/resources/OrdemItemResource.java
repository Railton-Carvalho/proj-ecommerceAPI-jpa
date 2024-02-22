package com.webspring.course.resources;

import com.webspring.course.entities.Order;
import com.webspring.course.entities.OrderItem;
import com.webspring.course.repositories.OrderItemRepository;
import com.webspring.course.services.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/api/OrdemItem")
public class OrdemItemResource implements Serializable {
    private OrderItemService service;
    public OrdemItemResource(OrderItemService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll(){
        List<OrderItem> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderItem> findById(@PathVariable Long id){
        OrderItem order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }

}
