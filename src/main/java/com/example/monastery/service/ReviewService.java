package com.example.monastery.service;

import com.example.monastery.dao.model.Review;
import com.example.monastery.dao.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews(){
        return reviewRepository.findAll().stream().sorted().collect(Collectors.toList());
    }

    public void save(Review review){
        review.setDate(LocalDateTime.now());
        reviewRepository.save(review);
    }


}
