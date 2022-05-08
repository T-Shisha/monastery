package com.example.monastery.mapper;

import com.example.monastery.dao.model.Review;
import com.example.monastery.dto.ReviewDTO;

import java.util.List;

public interface ReviewMapper {
    ReviewDTO convertToDTO(Review entity);

    Review convertToEntity(ReviewDTO carDTO);

    List<ReviewDTO> convertToDTO(List<Review> reviewsEntities);

    List<Review> convertToEntity(List<ReviewDTO> reviewsDTOs);
}
