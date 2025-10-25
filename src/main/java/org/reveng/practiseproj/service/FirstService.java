package org.reveng.practiseproj.service;

import java.util.ArrayList;
import java.util.List;

import org.reveng.practiseproj.entity.FirstEntity;
import org.reveng.practiseproj.repository.FirstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    private final FirstRepository firstRepository;

    @Autowired
    public FirstService(FirstRepository firstRepository) {
        this.firstRepository = firstRepository;
    }

    public String testDB(){
        FirstEntity firstEntity = new FirstEntity();
        List<FirstEntity> repo = new ArrayList<>();
        firstEntity.setId(1);
        firstEntity.setName("Sri");
        firstRepository.save(firstEntity);
        repo = firstRepository.findAll();
        return "Success";
    }
}
