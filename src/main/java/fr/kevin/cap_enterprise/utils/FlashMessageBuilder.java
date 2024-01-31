package fr.kevin.cap_enterprise.utils;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class FlashMessageBuilder {

    public static void createSuccessFlashMessage(
        RedirectAttributes redirectAttributes,
        String message
    ) {
        redirectAttributes.addFlashAttribute(
            "flashMessage",
            new FlashMessage(
                "success",
                message
            )
        );
    }

}
