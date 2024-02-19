package com.webspring.course.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date moment;

    @ManyToOne //diz ao JPA pra transformar em uma FK
    @JoinColumn(name = "client_id") //nome da FK do DB
    private User client;

    public Order(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
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
