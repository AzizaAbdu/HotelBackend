package com.example.Hotel.controler;

import com.example.Hotel.Repository.UserRepo;
import com.example.Hotel.model.User;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/User")
public class UserApi {

    @Autowired
    public UserRepo userRepo;

    @GetMapping("/GetAll")
    public List<User> getUser(){
        return userRepo.findAll();
    }

    @PostMapping( "/Save")
    public User createUser(@RequestBody User user){
        return userRepo.save(user);
    }





}
