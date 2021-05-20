package ru.shinepilates.finalprojectserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shinepilates.finalprojectserver.entity.NewsEntity;
import ru.shinepilates.finalprojectserver.entity.NotificationEntity;
import ru.shinepilates.finalprojectserver.model.NotificationModel;
import ru.shinepilates.finalprojectserver.service.NewsService;
import ru.shinepilates.finalprojectserver.service.NotificationService;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;


    @GetMapping("/news")
    public List<NewsEntity> getNews(){
        return newsService.getAllNews();
    }

    @PostMapping("/news")
    public NewsEntity postNews(@RequestBody NewsEntity news) {
        try {
            return newsService.createNews(news);
        } catch (Exception e) {
            e.printStackTrace();
            return new NewsEntity();
        }
    }

    @DeleteMapping("/news")
    public void deleteNews(@RequestBody NewsEntity news){
        newsService.deleteNews(news);
    }
    /*
    @PutMapping("/news/{id}")
    public NewsEntity updateNotification(@PathVariable Long id){
        try{
            return NotificationModel.toModel(notificationService.update(id));
        } catch (Exception e){
            NotificationModel model = new NotificationModel();
            model.setDate("wrong");
            return model;
        }
    }*/
}
