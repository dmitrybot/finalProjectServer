package ru.shinepilates.finalprojectserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shinepilates.finalprojectserver.entity.ReportEntity;
import ru.shinepilates.finalprojectserver.entity.UserEntity;
import ru.shinepilates.finalprojectserver.repository.ReportsRepository;
import ru.shinepilates.finalprojectserver.repository.UsersRepository;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportsRepository reportsRepository;

    public List<ReportEntity> getAllReports(){
        return reportsRepository.findAll();
    }

    public ReportEntity addReport(ReportEntity report){
        return reportsRepository.save(report);
    }

    public void deleteReport(ReportEntity report){
        for (ReportEntity r: reportsRepository.findAll()){
            if (r.getId() == report.getId()){
                reportsRepository.delete(r);
            }
        }
    }
}
