package com.example.monastery.service;

import com.example.monastery.dao.model.House;
import com.example.monastery.dao.model.Role;
import com.example.monastery.dao.model.User;
import com.example.monastery.dao.repository.HouseRepository;
import com.example.monastery.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HouseRepository houseRepository;

    public User getByUsername(String name) {
        return userRepository.findByUsername(name).orElseThrow(RuntimeException::new);
    }

    public boolean isExist(Long id) {
        return userRepository.existsById(id);
    }

    public void delete(Long id) {
        User user = getById(id);
        userRepository.delete(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<User> getAllByHouse(Long id) {
        return userRepository.findAllByHouse(id);
    }

    public boolean checkUserByName(String name) {
        try {
            getByUsername(name);
            return true;
        } catch (RuntimeException ex) {
            return false;
        }
    }
}
