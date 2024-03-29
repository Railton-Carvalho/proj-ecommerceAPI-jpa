package com.webspring.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webspring.course.entities.enum_class.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")

public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant moment;

    @ManyToOne //diz ao JPA pra transformar o att em uma FK(pesquisa a PK marcada por @Id no obj client// )
    @JoinColumn(name = "client_id") //nome da FK do DB
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    private Integer orderStatus;

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Payment payment;

    public Order(){}
    public Order(Long id, Instant moment,OrderStatus orderStatus, User user) {
        this.id = id;
        this.moment = moment;
        this.client = user;
        setOrderStatus(orderStatus);
    }


    public Set<OrderItem> getOrderItem() {
        return items;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }
    public Double getTotal(){
        Double total = 0.0;
        for (OrderItem oi: items){
            total += oi.getSubTotal();
        }
        return total;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
