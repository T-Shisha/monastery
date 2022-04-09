package com.example.monastery.dao.repository;

import com.example.monastery.dao.model.House;
import com.example.monastery.dao.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
  List<News> findAllByHouse (House house);

}
