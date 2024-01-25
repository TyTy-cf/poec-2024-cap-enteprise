package fr.kevin.cap_enterprise.controller;

import fr.kevin.cap_enterprise.mapping.UrlRoute;
import fr.kevin.cap_enterprise.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class GameController {

    private GameService gameService;

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

    @GetMapping(UrlRoute.URL_GAME_ID)
    public ModelAndView show(@PathVariable Long id, ModelAndView mav) {
        mav.setViewName("game/show");
        mav.addObject("game", gameService.findById(id));
        return mav;
    }

}