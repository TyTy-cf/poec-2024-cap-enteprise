package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {

    private ReviewRepository reviewRepository;

}
