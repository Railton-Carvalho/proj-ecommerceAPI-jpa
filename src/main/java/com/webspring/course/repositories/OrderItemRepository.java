package com.webspring.course.repositories;

import com.webspring.course.entities.OrderItem;
import com.webspring.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
