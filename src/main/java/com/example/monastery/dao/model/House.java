package com.example.monastery.dao.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @OneToMany(mappedBy = "house", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    private List<News> news;
//    @OneToMany(mappedBy = "house", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    private List<User> users;
}
