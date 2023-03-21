package com.usermanagement.usermanagement.controller;

import com.usermanagement.domain.entities.User;
import com.usermanagement.domain.repositories.abstraction.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private  IUserRepository userRepository;

    @GetMapping("")
    public List<User> Get(){

        return userRepository.getAll().join();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id){

        var user = userRepository.getUserById(id);
        return user.join();
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        userRepository.createUser(user);
        return user;
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User user) {
        user.Id = UUID.randomUUID();
        userRepository.updateUser(user);
        return user;
    }
    @GetMapping("average-salary")
    public double getUsersSalaryAverage(){
        List<User> users =  userRepository.getAll().join();

        double averageSalary = users.stream()
                               .mapToDouble(usr -> usr.Salary)
                               .average().orElse(0);
        return averageSalary;
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userRepository.deleteUser(id);
    }

}
