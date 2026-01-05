package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.DTO.ReviewDTO;
import fr.kevin.cap_enterprise.entity.*;
import fr.kevin.cap_enterprise.repository.ReviewRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOEntityInterface;
import fr.kevin.cap_enterprise.service.interfaces.DAOFindAllInterface;
import fr.kevin.cap_enterprise.service.interfaces.DAOFindByIdInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ReviewService implements
        DAOFindByIdInterface<Review>
{

    private ReviewRepository reviewRepository;

    private UserService userService;

    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Page<Review> findByUserNickname(String nickname, Pageable pageable) {
        return reviewRepository.findByModeratorIsNotNullOrGamerNickname(nickname, pageable);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
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
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.saveAndFlush(review);
    }

    /**
     * @param nickname of the logged-in user
     * @param id of the review to moderate
     * @param moderate the status : 0 to delete - 1 to accepted
     * @return boolean true if the review is accepted, false otherwise
     */
    public boolean moderateReview(String nickname, Long id, Long moderate) {
        Review review = findById(id);
        boolean isModerate = true;
        if (moderate == 1L) {
            review.setModerator((Moderator) userService.findByNickname(nickname));
            review.setModeratedAt(LocalDateTime.now());
        } else {
            reviewRepository.delete(review);
            isModerate = false;
        }
        reviewRepository.flush();
        return isModerate;
    }

    public Page<Review> getPageReviewByNickname(String nickname, Pageable pageable) {
        User user = userService.findByNickname(nickname);
        Page<Review> pageReviews = findByUserNickname(nickname, pageable);
        if (user.isModerator()) {
            Sort.Order order = pageable.getSort().getOrderFor("moderator");
            if (order != null) {
                if (order.isAscending()) {
                    pageReviews = reviewRepository.findByModeratorIsNull(pageable);
                } else {
                    pageReviews = reviewRepository.findByModeratorIsNotNull(pageable);
                }
            } else {
                pageReviews = reviewRepository.findAll(pageable);
            }
        }
        return pageReviews;
    }

    public Page<Review> findReviewsForProfile(
            User user,
            Principal principal,
            Pageable pageable
    ) {
        if (user.getNickname().equals(principal.getName())) {
            return reviewRepository.findAllByGamerNickname(user.getNickname(), pageable);
        }
        return reviewRepository.findByModeratorIsNotNullAndGamerNickname(user.getNickname(), pageable);
    }
}
