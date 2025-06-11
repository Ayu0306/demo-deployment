package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Service;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:5173")
public class DemoController {

    @Autowired
    UserRepository repository;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        List<UserEntity> entityList = repository.findAll();
        return entityList;

    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity entity){
      UserEntity userEntity =   repository.save(entity);
      return ResponseEntity.ok(userEntity);
    }
 }
