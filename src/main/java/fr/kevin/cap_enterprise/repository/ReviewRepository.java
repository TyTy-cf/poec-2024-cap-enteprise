package fr.kevin.cap_enterprise.repository;

import fr.kevin.cap_enterprise.entity.Game;
import fr.kevin.cap_enterprise.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByGameAndModeratorIsNotNull(Game game, Pageable pageable);

    @Query("select r from Review r where r.moderatedAt is not null OR (r.gamer.nickname = ?1 and r.moderatedAt is null)")
    Page<Review> findByUserNickname(String nickname, Pageable pageable);
}