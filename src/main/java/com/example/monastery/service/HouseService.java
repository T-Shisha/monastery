package com.example.monastery.service;

import com.example.monastery.dao.model.House;
import com.example.monastery.dao.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;

    public List<House> getAll(){
       return houseRepository.findAll();
    }
}
