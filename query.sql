
-- Affiche la note moyenne des jeux
SELECT game.name, (SUM(review.rating)/COUNT(*))
FROM review
         JOIN game ON review.game_id = game.id
GROUP BY game.id
ORDER BY (SUM(review.rating)/COUNT(*)) DESC;