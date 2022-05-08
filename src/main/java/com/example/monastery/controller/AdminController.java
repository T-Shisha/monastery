package com.example.monastery.controller;

import com.example.monastery.dao.model.House;
import com.example.monastery.dao.model.News;
import com.example.monastery.dao.model.User;
import com.example.monastery.dto.NewsDTO;
import com.example.monastery.mapper.NewsMapper;
import com.example.monastery.service.HouseService;
import com.example.monastery.service.NewsService;
import com.example.monastery.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;

    private NewsMapper newsMapper = Mappers.getMapper(NewsMapper.class);



    @PostMapping("/houses/add")
    public void addHouse(@RequestBody House house) {
        if (!houseService.checkHouseByName(house.getName())) {
            houseService.save(house);
        }
    }

    @GetMapping("/houses/{id}/delete")
    public void deleteHouse(@PathVariable(value = "id") Long id) {
        if (!houseService.isExist(id)) {
            houseService.delete(id);
        }
    }

    @GetMapping("/houses")
    public List<House> getHouses() {
        return houseService.getAll();
    }

//    @GetMapping("/houses/{id}/nuns")
//    public List<User> getNuns(@PathVariable(value = "id") Long id) {
//        return userService.getAllByHouse(id);
//    }

    @PostMapping("/houses/{id}/nuns/add")
    public void addNun(@PathVariable Long id, @RequestBody User user) {
        if (!userService.checkUserByName(user.getUsername())) {
            userService.save(user);
        }
    }

    @GetMapping("/houses/{id}/nuns/{id_nun}/delete")
    public void deleteNun(@PathVariable Long id, @PathVariable Long id_nun) {
        if (!userService.isExist(id_nun)) {
            userService.delete(id_nun);
        }
    }
    @PostMapping("/news/{id}/edit/{id_news}")
    public void editNews(@PathVariable(value = "id") Long id, @PathVariable(value = "id_news") Long id_news, @RequestBody News news) {
        newsService.save(news);
    }

    @PostMapping("/houses/{id}/news/add")
    public void addNews(@PathVariable Long id, @RequestBody News news, @RequestParam(name="fileField",required=false) MultipartFile fileField) throws IOException {
        newsService.save(news, fileField);
    }

    @GetMapping("/houses/{id}/news/{id_news}/delete")
    public void deleteNews(@PathVariable(value = "id") Long id, @PathVariable(value = "id_news") Long id_news) {
        if (newsService.isExist(id_news)) {
            newsService.delete(id_news);
        }
    }

    @GetMapping("/houses/{id}/news/{id_news}/edit")
    public NewsDTO getNewsForEdit(@PathVariable(value = "id") Long id, @PathVariable(value = "id_news") Long id_news) {
        return newsMapper.convertToDTO(newsService.getById(id_news));


    }

    @GetMapping("/houses/{id}/news")
    public List<NewsDTO> getNewsForHouse(@PathVariable(value = "id") Long id) {
        return newsMapper.convertToDTO(newsService.getNewsByHouse(id));

    }


}
