package ru.shinepilates.finalprojectserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shinepilates.finalprojectserver.entity.UserEntity;
import ru.shinepilates.finalprojectserver.exeptions.UserAlreadyExistException;
import ru.shinepilates.finalprojectserver.model.UserModel;
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

    public UserEntity update(UserModel user){
        for (UserEntity u: usersRepository.findAll()){
            if (u.getPhone().equals(user.getPhone())){
                UserEntity userEntity = user.ModelToEntity();
                userEntity.setId(u.getId());
                return usersRepository.save(userEntity);
            }
        }
        return new UserEntity();
    }

    public UserEntity updateWithPhone(UserModel user){
        for (UserEntity u: usersRepository.findAll()){
            if (u.getPhone().equals(user.getPhone())){
                UserEntity u2 = new UserEntity();
                u2.setPhone("-");
                return u2;
            }
            if (u.getPhone().equals(user.getLastphone())){
                user.setId(u.getId());
            }
        }
        return usersRepository.save(user.ModelToEntity());
    }
}
