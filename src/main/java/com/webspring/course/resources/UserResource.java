package com.webspring.course.resources;

import com.webspring.course.entities.User;
import com.webspring.course.services.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.naming.Name;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping()
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
        //Maneira Padrâo de pegar a location do obj a ser excluido do DB
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/{n1}/{n2}")
    public ResponseEntity<Integer> stupidSum(@PathVariable("id") Integer n1, @PathVariable("id2")  Integer n2){
        Integer sum = n1+n2;
        return ResponseEntity.ok().body(sum);
    }
    @PutMapping(name = "/{id}")
    public ResponseEntity<Void> updateByName(@PathVariable String name){
        for (User us: service.findAll()){
            if (us.getName().equals(name)){
                User entity = service.findById(us.getId());

            }
        }
        return null;
    }

}