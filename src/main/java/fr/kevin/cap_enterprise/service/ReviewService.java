package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.DTO.ReviewDTO;
import fr.kevin.cap_enterprise.entity.Game;
import fr.kevin.cap_enterprise.entity.Gamer;
import fr.kevin.cap_enterprise.entity.Review;
import fr.kevin.cap_enterprise.repository.ReviewRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOFindAllInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService implements DAOFindAllInterface<Review> {

    private ReviewRepository reviewRepository;

    private UserService userService;

    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    public Page<Review> findByUserNickname(String nickname, Pageable pageable) {
        return reviewRepository.findByUserNickname(nickname, pageable);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Page<Review> findAllByGame(Game game, Pageable pageable) {
        return reviewRepository.findAllByGameAndModeratorIsNotNull(game, pageable);
    }

    public Review createReview(ReviewDTO reviewDTO, Game game, String name) {
        Review review = new Review();
        review.setGame(game);
        review.setGamer((Gamer) userService.findByNickname(name));
        review.setDescription(reviewDTO.getDescription());
        review.setRating(reviewDTO.getRating());
        return reviewRepository.saveAndFlush(review);
    }

    public void moderateReview(Long id, boolean status) {

    }
}
