package com.webspring.course.repositories;

import com.webspring.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //n precisa pois a JpaRepository ja aplica por padrâo
public interface UserRepository extends JpaRepository<User,Long> {
    // Não é necessário definir nenhum método aqui.
    // O Spring Data JPA irá fornecer automaticamente métodos para operações básicas de CRUD.
}
