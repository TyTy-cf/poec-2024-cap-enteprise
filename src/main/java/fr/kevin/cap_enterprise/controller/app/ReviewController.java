package fr.kevin.cap_enterprise.controller.app;

import fr.kevin.cap_enterprise.mapping.UrlRoute;
import fr.kevin.cap_enterprise.service.ReviewService;
import fr.kevin.cap_enterprise.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class ReviewController {

    private ReviewService reviewService;

    private UserService userService;

    @GetMapping(UrlRoute.URL_REVIEW_MODERATE)
    public ModelAndView moderate(
            @PathVariable Long id,
            @PathVariable Long moderate,
            ModelAndView modelAndView,
            RedirectAttributes redirectAttributes,
            Principal principal
    ) {
        reviewService.moderateReview(userService.findByNickname(principal.getName()), id, moderate);
        redirectAttributes.addFlashAttribute("messageModerate", "Le commentaire a bien été modéré !");
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}