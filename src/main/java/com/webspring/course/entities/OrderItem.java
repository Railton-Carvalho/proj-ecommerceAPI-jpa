package com.webspring.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webspring.course.entities.pk.OrderItemPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_ordem_item")
public class OrderItem implements Serializable {
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem(){

    }
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;

    }
    public Double getSubTotal(){
        return price*quantity;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    public Product getProduct(){
        return id.getProduct();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
