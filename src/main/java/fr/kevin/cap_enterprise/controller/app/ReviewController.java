package fr.kevin.cap_enterprise.controller.app;

import fr.kevin.cap_enterprise.mapping.UrlRoute;
import fr.kevin.cap_enterprise.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping(UrlRoute.URL_REVIEW_MODERATE)
    public ModelAndView moderate(
            ModelAndView modelAndView,
            @PathVariable Long id,
            @PathVariable boolean status
    ) {
        reviewService.moderateReview(id, status);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}