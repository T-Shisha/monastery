package com.example.monastery.dao.repository;

import com.example.monastery.dao.model.News;
import com.example.monastery.dao.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
}
