package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.entity.Review;
import fr.kevin.cap_enterprise.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private ReviewRepository reviewRepository;

    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }
}
