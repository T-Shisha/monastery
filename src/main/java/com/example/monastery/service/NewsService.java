package com.example.monastery.service;

import com.example.monastery.dao.model.House;
import com.example.monastery.dao.model.News;
import com.example.monastery.dao.repository.HouseRepository;
import com.example.monastery.dao.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private HouseRepository houseRepository;

    public News getById(Long id){
        return newsRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    public List<News> getAllNews(){
        return newsRepository.findAll().stream().sorted().collect(Collectors.toList());
    }

    public List<News> getNewsByHouse(Long id){
        House house = houseRepository.findById(id).orElseThrow(RuntimeException::new);
        return newsRepository.findAllByHouse(house).stream().sorted().collect(Collectors.toList());
    }
    public void delete(Long id){
        News news = getById(id);
        newsRepository.delete(news);
    }
    public void save(News news){
        newsRepository.save(news);
    }

    public boolean isExist(Long id) {
        return newsRepository.existsById(id);
    }
}
