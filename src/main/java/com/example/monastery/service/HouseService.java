package com.example.monastery.service;

import com.example.monastery.dao.model.House;
import com.example.monastery.dao.model.News;
import com.example.monastery.dao.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;

    public List<House> getAll() {
        return houseRepository.findAll();
    }

    public House getByName(String name) {
        return houseRepository.findByName(name).orElseThrow(RuntimeException::new);
    }

    public boolean isExist(Long id) {
        return houseRepository.existsById(id);
    }

    public void delete(Long id){
        House house = getById(id);
        houseRepository.delete(house);
    }
    public void save(House house){
        houseRepository.save(house);
    }

    public House getById(Long id){
        return houseRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public boolean checkHouseByName(String name) {
        try {
            getByName(name);
            return true;
        } catch (RuntimeException ex) {
            return false;
        }
    }

}
