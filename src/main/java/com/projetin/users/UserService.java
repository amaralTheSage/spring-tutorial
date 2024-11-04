package com.projetin.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getUsers(){
        return this.repository.findAll();
    }

    public User findUser(long id){
        if(this.repository.findById(id).isEmpty()){
            throw new IllegalStateException("Nao tem isso dae porra");
        }

        return this.repository.findById(id).get();
    }

    public User createUser(User body){
        return this.repository.save(body);
    }

    public User deleteUser(long id){
        if(this.repository.findById(id).isEmpty()){
            throw new IllegalStateException("User not found");
        }

        User user = this.repository.findById(id).get();
        this.repository.deleteById(id);

        return user;
    }

    public User updateUser(long id, String name, String password){
        if(this.repository.findById(id).isEmpty()){
            throw new IllegalStateException("User not found");
        }

        User user = this.repository.findById(id).get();

        if(name !=null && !name.isEmpty()){
            user.setName(name);
        }

        if(password !=null && !password.isEmpty()){
            user.setPassword(password);
        }

        return user;
    }
}
