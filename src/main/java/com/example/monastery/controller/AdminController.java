package com.example.monastery.controller;

import com.example.monastery.dao.model.House;
import com.example.monastery.dao.model.News;
import com.example.monastery.dao.model.User;
import com.example.monastery.dao.repository.HouseRepository;
import com.example.monastery.service.HouseService;
import com.example.monastery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private UserService userService;

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

    @GetMapping("/houses/{id}/nuns")
    public List<User> getNuns(@PathVariable(value = "id") Long id) {
        return userService.getAllByHouse(id);
    }

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

}
