package ru.shinepilates.finalprojectserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shinepilates.finalprojectserver.entity.UserEntity;
import ru.shinepilates.finalprojectserver.exeptions.UserAlreadyExistException;
import ru.shinepilates.finalprojectserver.repository.UsersRepository;
import ru.shinepilates.finalprojectserver.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserEntity> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public void postUser(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            //return "Пользователь успешно сохранен";
        } catch (UserAlreadyExistException e) {
            //return e.getMessage();
        } catch (Exception e) {
            //return "Произошла ошибка";
        }
    }
    /*
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        for (Employee employee: employees){
            if (employee.getId() == id){
                employees.remove(employee);
            }
        }
    }
    */
    @PutMapping("/users")
    public UserEntity updateUser(@RequestBody UserEntity user){
        return userService.update(user);
    }
}

