package com.example.monastery.controller;

import com.example.monastery.dao.model.House;
import com.example.monastery.dao.model.News;
import com.example.monastery.dto.NewsDTO;
import com.example.monastery.mapper.NewsMapper;
import com.example.monastery.service.HouseService;
import com.example.monastery.service.NewsService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private NewsService newsService;
    private NewsMapper newsMapper = Mappers.getMapper(NewsMapper.class);



    @GetMapping("/news/{id}")
    public List<NewsDTO> getNewsByHouse(@PathVariable Long id) {
        return newsMapper.convertToDTO(newsService.getNewsByHouse(id));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/news")
    public List<NewsDTO> getNews() {
        return newsMapper.convertToDTO(newsService.getAllNews());
    }

}
