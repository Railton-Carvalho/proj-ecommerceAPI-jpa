package com.webspring.course.config;

import com.webspring.course.entities.User;
import com.webspring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@Profile("test")//onde o spring vai rodar essa configuraçâo
public class TestConfig implements CommandLineRunner {
    @Autowired //realizar a injeção de dependência de forma automática.
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {//metódo que roda no instant run do program
        Long numero = null; // Isso é válido, pois Long é uma classe e pode ser nulo

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));

    }
}
