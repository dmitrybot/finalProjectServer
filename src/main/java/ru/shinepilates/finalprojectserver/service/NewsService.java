package ru.shinepilates.finalprojectserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shinepilates.finalprojectserver.entity.NewsEntity;
import ru.shinepilates.finalprojectserver.entity.ReportEntity;
import ru.shinepilates.finalprojectserver.repository.NewsRepository;
import ru.shinepilates.finalprojectserver.repository.ReportsRepository;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsEntity> getAllNews(){
        return newsRepository.findAll();
    }

    public NewsEntity createNews(NewsEntity news){
        return newsRepository.save(news);
    }

    public void deleteNews(NewsEntity news){
        for (NewsEntity n: newsRepository.findAll()){
            if (n.getId() == news.getId()){
                newsRepository.delete(n);
            }
        }
    }
}
