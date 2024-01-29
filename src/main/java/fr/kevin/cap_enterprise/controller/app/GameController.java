package fr.kevin.cap_enterprise.controller.app;

import fr.kevin.cap_enterprise.DTO.ReviewDTO;
import fr.kevin.cap_enterprise.entity.Game;
import fr.kevin.cap_enterprise.mapping.UrlRoute;
import fr.kevin.cap_enterprise.service.GameService;
import fr.kevin.cap_enterprise.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class GameController {

    private GameService gameService;

    private ReviewService reviewService;

    @GetMapping(UrlRoute.URL_GAME)
    public ModelAndView index(
            ModelAndView mav,
            @PageableDefault(
                size = 6, // nb Element par page
                sort = { "publishedAt" }, // order by
                direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        mav.setViewName("game/index");
        mav.addObject("pageGames", gameService.findAll(pageable));
        return mav;
    }

    @GetMapping(UrlRoute.URL_GAME_SLUG)
    public ModelAndView show(
        @PathVariable String slug,
        ModelAndView mav,
        Principal principal,
        @ModelAttribute("reviewFormMessage") String reviewFormMessage,
        @PageableDefault(
            size = 6, // nb Element par page
            sort = { "createdAt" }, // order by
            direction = Sort.Direction.DESC
        ) Pageable pageable
    ) {
        mav.setViewName("game/show");
        if (principal != null) {
            mav.addObject("reviewDto", new ReviewDTO());
        }
        Game game = gameService.findBySlug(slug);
        mav.addObject("formMessage", reviewFormMessage);
        mav.addObject("game", game);
        mav.addObject("pageReviews", reviewService.findAllByGame(game, pageable));
        return mav;
    }

    @PostMapping(UrlRoute.URL_GAME_SLUG)
    public ModelAndView show(
            @PathVariable String slug,
            ModelAndView mav,
            Principal principal,
            @ModelAttribute("reviewDto") ReviewDTO reviewDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            mav.setViewName("game/show");
            return mav;
        }
        reviewService.createReview(
            reviewDTO,
            gameService.findBySlug(slug),
            principal.getName()
        );
        redirectAttributes.addFlashAttribute("reviewFormMessage", "Votre commentaire a bien été enregistré, il est actuellement en attente de modération !");
        mav.setViewName("redirect:" + UrlRoute.URL_GAME + "/" + slug);
        return mav;
    }
}