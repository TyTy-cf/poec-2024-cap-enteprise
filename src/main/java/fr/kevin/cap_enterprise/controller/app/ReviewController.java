package fr.kevin.cap_enterprise.controller.app;

import fr.kevin.cap_enterprise.mapping.UrlRoute;
import fr.kevin.cap_enterprise.service.ReviewService;
import fr.kevin.cap_enterprise.service.UserService;
import fr.kevin.cap_enterprise.utils.FlashMessage;
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
        boolean isModerate = reviewService.moderateReview(userService.findByNickname(principal.getName()), id, moderate);
        if (isModerate) {
            redirectAttributes.addFlashAttribute(
                    "flashMessage",
                    new FlashMessage("success", "Le commentaire a bien été modéré !")
            );
        } else {
            redirectAttributes.addFlashAttribute(
                    "flashMessage",
                    new FlashMessage("warning", "Le commentaire a bien été supprimé !")
            );
        }
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}