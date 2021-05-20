package ru.shinepilates.finalprojectserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shinepilates.finalprojectserver.entity.NewsEntity;
import ru.shinepilates.finalprojectserver.entity.TrenersEntity;
import ru.shinepilates.finalprojectserver.repository.NewsRepository;
import ru.shinepilates.finalprojectserver.repository.TrenersRepository;

import java.util.List;

@Service
public class TrenersService {

    @Autowired
    private TrenersRepository trenersRepository;

    public List<TrenersEntity> getAllTreners(){
        return trenersRepository.findAll();
    }

    public TrenersEntity createTreners(TrenersEntity treners){
        return trenersRepository.save(treners);
    }

    public void deleteTreners(TrenersEntity treners){
        for (TrenersEntity t: trenersRepository.findAll()){
            if (t.getId() == treners.getId()){
                trenersRepository.delete(t);
            }
        }
    }
}
