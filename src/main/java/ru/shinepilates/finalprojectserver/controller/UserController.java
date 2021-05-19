package ru.shinepilates.finalprojectserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shinepilates.finalprojectserver.entity.UserEntity;
import ru.shinepilates.finalprojectserver.exeptions.UserAlreadyExistException;
import ru.shinepilates.finalprojectserver.model.NotificationModel;
import ru.shinepilates.finalprojectserver.model.UserModel;
import ru.shinepilates.finalprojectserver.model.UserModelReturn;
import ru.shinepilates.finalprojectserver.repository.UsersRepository;
import ru.shinepilates.finalprojectserver.service.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserModelReturn> getAll(){
        return userService.getAllUsers().stream().map(UserModelReturn::toModel).collect(Collectors.toList());
    }

    @PostMapping("/user")
    public UserModelReturn getUser(@RequestBody UserEntity user){
        return userService.authorisation(user);
    }

    @PostMapping("/users")
    public UserModelReturn postUser(@RequestBody UserEntity user) {
        UserModelReturn u = new UserModelReturn();
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

    @DeleteMapping("/users")
    public void deleteUser(@RequestBody UserEntity user){
        userService.delete(user);
    }

    @PutMapping("/users")
    public UserModelReturn updateUser(@RequestBody UserModel user){
        String s = user.getLastphone();
        if (s.equals("-")){
            UserEntity u = userService.update(user);
            return UserModelReturn.toModel(u);
        } else {
            return UserModelReturn.toModel(userService.updateWithPhone(user));
        }
    }
}

