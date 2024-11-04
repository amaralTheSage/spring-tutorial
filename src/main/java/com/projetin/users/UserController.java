package com.projetin.users;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getUsers(){
        return this.service.getUsers();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") long id){
        return this.service.findUser(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody @Valid User body){
        return this.service.createUser(body);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUser(@PathVariable("id") long id){
        return this.service.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable("id") long id, @RequestParam(required = false) String name,
                           @RequestParam(required =
            false) String password){
        return this.service.updateUser(id, name, password);
    }


}
