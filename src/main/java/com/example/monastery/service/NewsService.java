package com.example.monastery.service;

import com.example.monastery.dao.model.News;
import com.example.monastery.dao.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public News getById(Long id){
        return newsRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
