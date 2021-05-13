package ru.shinepilates.finalprojectserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shinepilates.finalprojectserver.entity.UserEntity;
import ru.shinepilates.finalprojectserver.exeptions.UserAlreadyExistException;
import ru.shinepilates.finalprojectserver.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (usersRepository.findByPhone(user.getPhone()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем существует");
        }
        return usersRepository.save(user);
    }

    public List<UserEntity> getAllUsers(){
        return usersRepository.findAll();
    }

    public UserEntity update(UserEntity user){
        for (UserEntity u: usersRepository.findAll()){
            if (u.getPhone().equals(user.getPhone())){
                user.setId(u.getId());
                return usersRepository.save(user);
            }
        }
        return new UserEntity();
    }
}
