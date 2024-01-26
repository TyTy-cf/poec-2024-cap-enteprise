package fr.kevin.cap_enterprise.controller;

import fr.kevin.cap_enterprise.mapping.UrlRoute;
import fr.kevin.cap_enterprise.service.ReviewService;
import fr.kevin.cap_enterprise.utils.ExcelReviewService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class HomeController {

    private ReviewService reviewService;

    private ExcelReviewService excelService;

    @GetMapping("/")
    public ModelAndView index(
            ModelAndView mav,
            Principal principal,
            @PageableDefault(
                size = 6, // nb Element par page
                sort = { "createdAt" }, // order by
                direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        if (principal == null) {
            mav.setViewName("redirect:/login");
            return mav;
        }
        mav.addObject("pageReviews", reviewService.findAll(pageable));
        mav.setViewName("index");
        return mav;
    }

    @GetMapping(UrlRoute.URL_EXPORT)
    public void downloadExcel(HttpServletResponse response) {
        try {
            File file = excelService.writeExcel();
            ByteArrayInputStream excelToByte = new ByteArrayInputStream(
                Files.readAllBytes(Paths.get(file.getAbsolutePath()))
            );
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
            IOUtils.copy(excelToByte, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
