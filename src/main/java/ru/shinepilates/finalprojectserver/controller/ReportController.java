package ru.shinepilates.finalprojectserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shinepilates.finalprojectserver.entity.ReportEntity;
import ru.shinepilates.finalprojectserver.entity.UserEntity;
import ru.shinepilates.finalprojectserver.exeptions.UserAlreadyExistException;
import ru.shinepilates.finalprojectserver.model.UserModel;
import ru.shinepilates.finalprojectserver.service.ReportService;
import ru.shinepilates.finalprojectserver.service.UserService;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;


    @GetMapping("/reports")
    public List<ReportEntity> getReports(){
        return reportService.getAllReports();
    }
    /*
    @PostMapping("/user")
    public UserEntity getUser(@RequestBody UserEntity user){
        return userService.authorisation(user);
    }
    */
    @PostMapping("/reports")
    public ReportEntity postReport(@RequestBody ReportEntity report) {
        ReportEntity r = new ReportEntity();
        try {
            r = reportService.addReport(report);
            return r;
        } catch (Exception e) {
            return r;
        }
    }

    @DeleteMapping("/reports")
    public void deleteReport(@RequestBody ReportEntity report){
        reportService.deleteReport(report);
    }
    /*
    @PutMapping("/users")
    public UserEntity updateUser(@RequestBody UserModel user){
        String s = user.getLastphone();
        if (s.equals("-")){
            return userService.update(user);
        } else {
            return userService.updateWithPhone(user);
        }
    }
    */
}
