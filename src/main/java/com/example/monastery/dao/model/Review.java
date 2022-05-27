package com.example.monastery.dao.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Review implements Comparable<Review>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    @Column(columnDefinition="TEXT")
    private String text;
    private LocalDateTime date;
    @Override
    public int compareTo(Review o) {
        return date.compareTo(o.getDate());
    }
}
