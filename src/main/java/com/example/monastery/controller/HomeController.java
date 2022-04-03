package com.example.monastery.controller;

import com.example.monastery.dao.model.House;
import com.example.monastery.dao.model.News;
import com.example.monastery.service.HouseService;
import com.example.monastery.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<House> getClients() {
        return houseService.getAll();
    }

    @GetMapping("/news/{id}")
    public News getNews(@PathVariable Long id) {
        return newsService.getById(id);
    }

}
