package com.example.monastery.dao.model;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class News implements Comparable<News> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String text;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id", nullable = false)
    private House house;
    private String imageLocation;

    @Override
    public int compareTo(News o) {
        return date.compareTo(o.getDate());
    }
}
