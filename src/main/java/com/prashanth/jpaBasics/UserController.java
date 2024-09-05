package com.prashanth.jpaBasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/get_users")
    public ResponseEntity<List<User>> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/get_user")
    public ResponseEntity<User> getUser(@RequestParam("id") int id){
        return userService.getUser(id);
    }

    @PutMapping("/update_name")
    public ResponseEntity<User> updateName(@RequestParam("name") String name, @RequestParam("id") int id){
        return userService.updateName(name, id);
    }

    @DeleteMapping("/delete_users")
    public ResponseEntity<Void> deleteUsers(){
        userService.deleteUsers();
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
