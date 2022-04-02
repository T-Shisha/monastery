package com.example.monastery.dao.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "house", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<News> news;
}
