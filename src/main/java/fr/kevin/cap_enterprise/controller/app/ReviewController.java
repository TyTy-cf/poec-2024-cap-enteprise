package fr.kevin.cap_enterprise.controller.app;

import fr.kevin.cap_enterprise.mapping.UrlRoute;
import fr.kevin.cap_enterprise.service.ReviewService;
import fr.kevin.cap_enterprise.utils.FlashMessage;
import fr.kevin.cap_enterprise.utils.FlashMessageBuilder;
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

    private FlashMessageBuilder flashMessageBuilder;

    @GetMapping(UrlRoute.URL_REVIEW_MODERATE_PATH)
    public ModelAndView moderate(
            @PathVariable Long id,
            @PathVariable Long moderate,
            ModelAndView modelAndView,
            RedirectAttributes redirectAttributes,
            Principal principal
    ) {
        boolean isModerate = reviewService.moderateReview(principal.getName(), id, moderate);
        FlashMessage flashMessage = flashMessageBuilder.createSuccessFlashMessage("Le commentaire a bien été modéré !");
        if (!isModerate) {
            flashMessage = flashMessageBuilder.createWarningFlashMessage("Le commentaire a bien été supprimé !");
        }
        redirectAttributes.addFlashAttribute("flashMessage", flashMessage);
        modelAndView.setViewName("redirect:/?sort=moderator,asc");
        return modelAndView;
    }

}