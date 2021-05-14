package ru.shinepilates.finalprojectserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shinepilates.finalprojectserver.entity.UserEntity;
import ru.shinepilates.finalprojectserver.exeptions.UserAlreadyExistException;
import ru.shinepilates.finalprojectserver.model.UserModel;
import ru.shinepilates.finalprojectserver.repository.UsersRepository;
import ru.shinepilates.finalprojectserver.service.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserEntity> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public UserEntity postUser(@RequestBody UserEntity user) {
        UserEntity u = new UserEntity();
        try {
            userService.registration(user);
            u.setFirstname("Пользователь успешно сохранен");
            return u;
        } catch (UserAlreadyExistException e) {
            u.setFirstname(e.getMessage());
            return u;
        } catch (Exception e) {
            u.setFirstname("Произошла ошибка");
            return u;
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
    public UserEntity updateUser(@RequestBody UserModel user){
        String s = user.getLastphone();
        if (s.equals("-")){
            return userService.update(user);
        } else {
            return userService.updateWithPhone(user);
        }
    }
}

