package com.example.monastery.controller;

import com.example.monastery.dao.model.News;
import com.example.monastery.dao.model.Review;
import com.example.monastery.dto.NewsDTO;
import com.example.monastery.dto.ReviewDTO;
import com.example.monastery.mapper.ReviewMapper;
import com.example.monastery.service.ReviewService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    private ReviewMapper reviewMapper = Mappers.getMapper(ReviewMapper.class);

    @GetMapping("/main")
    public List<ReviewDTO> getNews() {
        return reviewMapper.convertToDTO(reviewService.getAllReviews());
    }

    @PostMapping("/review")
    public void addReview(@PathVariable Long id, @RequestBody Review review) {
        reviewService.save(review);
    }
}
