package com.example.monastery.mapper;

import com.example.monastery.dao.model.News;
import com.example.monastery.dto.NewsDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface  NewsMapper {
    NewsDTO convertToDTO(News entity);

    News convertToEntity(NewsDTO carDTO);

    List<NewsDTO> convertToDTO(List<News> newsEntities);

    List<News> convertToEntity(List<NewsDTO> newsDTOs);

}
