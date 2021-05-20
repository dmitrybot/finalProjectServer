package ru.shinepilates.finalprojectserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shinepilates.finalprojectserver.entity.NewsEntity;
import ru.shinepilates.finalprojectserver.entity.TrenersEntity;
import ru.shinepilates.finalprojectserver.service.NewsService;
import ru.shinepilates.finalprojectserver.service.TrenersService;

import java.util.List;

@RestController
public class TrenersController {

    @Autowired
    private TrenersService trenersService;


    @GetMapping("/treners")
    public List<TrenersEntity> getTreners(){
        return trenersService.getAllTreners();
    }

    @PostMapping("/treners")
    public TrenersEntity postTreners(@RequestBody TrenersEntity treners) {
        try {
            return trenersService.createTreners(treners);
        } catch (Exception e) {
            e.printStackTrace();
            return new TrenersEntity();
        }
    }

    @DeleteMapping("/treners")
    public void deleteTreners(@RequestBody TrenersEntity treners){
        trenersService.deleteTreners(treners);
    }

}
