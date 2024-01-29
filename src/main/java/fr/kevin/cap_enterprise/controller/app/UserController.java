package fr.kevin.cap_enterprise.controller.app;

import fr.kevin.cap_enterprise.mapping.UrlRoute;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class UserController {

    @GetMapping(UrlRoute.URL_USER)
    public ModelAndView show(ModelAndView mav) {
        return mav;
    }

}