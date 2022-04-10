package com.example.monastery.controller;

import com.example.monastery.dao.model.News;
import com.example.monastery.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('Nun')")
@RestController
public class NunController {
    @Autowired
    private NewsService newsService;

    @PostMapping("/news/{id}/edit/{id_news}")
    public void editNews(@PathVariable(value = "id") Long id, @PathVariable(value = "id") Long id_news, @RequestBody News news) {
        newsService.save(news);
    }

    @PostMapping("/news/{id}/add")
    public void addNews(@PathVariable Long id, @RequestBody News news) {
        newsService.save(news);
    }

    @GetMapping("/news/{id}/delete/{id_news}")
    public void deleteNews(@PathVariable(value = "id") Long id, @PathVariable(value = "id") Long id_news) {
        if (!newsService.isExist(id_news)) {
            newsService.delete(id_news);
        }
    }

    @GetMapping("/news/{id}/edit/{id_news}")
    public News getNewsForEdit(@PathVariable(value = "id") Long id, @PathVariable(value = "id") Long id_news) {
        return newsService.getById(id_news);

    }

}
