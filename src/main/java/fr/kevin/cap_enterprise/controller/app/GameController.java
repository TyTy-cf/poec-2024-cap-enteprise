package fr.kevin.cap_enterprise.controller.app;

import fr.kevin.cap_enterprise.DTO.GameDTO;
import fr.kevin.cap_enterprise.DTO.ReviewDTO;
import fr.kevin.cap_enterprise.entity.BusinessModel;
import fr.kevin.cap_enterprise.entity.Game;
import fr.kevin.cap_enterprise.mapping.UrlRoute;
import fr.kevin.cap_enterprise.repository.GenreRepository;
import fr.kevin.cap_enterprise.service.*;
import fr.kevin.cap_enterprise.utils.FlashMessage;
import fr.kevin.cap_enterprise.utils.FlashMessageBuilder;
import jakarta.validation.Valid;
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

    private GenreService genreService;

    private ClassificationService classificationService;

    private BusinessModelService businessModelService;

    private PublisherService publisherService;

    private PlatformService platformService;

    private FlashMessageBuilder flashMessageBuilder;

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
        @ModelAttribute("flashMessage") FlashMessage flashMessage,
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
        mav.addObject("flashMessage", flashMessage);
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
        redirectAttributes.addFlashAttribute(
            "flashMessage",
            flashMessageBuilder.createSuccessFlashMessage("Votre commentaire a bien été enregistré, il est actuellement en attente de modération !")
        );
        mav.setViewName("redirect:" + UrlRoute.URL_GAME + "/" + slug);
        return mav;
    }

    @GetMapping(UrlRoute.URL_GAME_NEW)
    public ModelAndView create(ModelAndView mav) {
        mav.setViewName("game/new");
        mav.addObject("gameDto", new GameDTO());
        mav.addObject("genres", genreService.findAllSorted());
        mav.addObject("classifications", classificationService.findAllSorted());
        mav.addObject("businessModels", businessModelService.findAllSorted());
        mav.addObject("publishers", publisherService.findAllSorted());
        mav.addObject("platforms", platformService.findAllSorted());
        return mav;
    }

    @PostMapping(UrlRoute.URL_GAME_NEW)
    public ModelAndView create(
        ModelAndView mav,
        @ModelAttribute("gameDto") GameDTO gameDTO,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes,
        Principal principal
    ) {
        if (bindingResult.hasErrors()) {
            mav.setViewName("game/new");
            return mav;
        }

        redirectAttributes.addFlashAttribute(
            "flashMessage",
            flashMessageBuilder.createSuccessFlashMessage("Jeu créé avec succès !")
        );
        mav.setViewName("redirect:" + UrlRoute.URL_GAME + "/" + gameService.create(gameDTO, principal.getName()).getSlug());
        return mav;
    }
}