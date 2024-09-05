package com.prashanth.jpaBasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public ResponseEntity<String> addUser(User user){
        userRepository.save(user);
        return new ResponseEntity<>("User added", HttpStatus.CREATED);
    }
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.FOUND);
    }
    public ResponseEntity<User> getUser(int id){
        return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.FOUND);
    }
    public ResponseEntity<User> updateName(String name, int id){
        User user = userRepository.findById(id).get();
        user.setName(name);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    public void deleteUsers(){
        userRepository.deleteAll();
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
