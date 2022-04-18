package com.example.monastery.dto;

import com.example.monastery.dao.model.House;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsDTO {
    private Long id;
    private String name;
    private String text;
    private LocalDateTime date;
   @JsonIgnore
    private House house;
}
