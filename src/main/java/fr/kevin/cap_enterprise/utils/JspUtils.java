package fr.kevin.cap_enterprise.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@AllArgsConstructor
public class JspUtils {

    public String excerpt(String text, int size) {
        if (text.length() <= size) return text;
        return text.substring(0, size) + "...";
    }

    public String getCssClas(float rating) {
        if (rating <= 5) return "rating-5";
        if (rating <= 10) return "rating-10";
        if (rating <= 15) return "rating-15";
        if (rating < 20) return "rating-19";
        return "rating-20";
    }

    public String getStringRating(float rating) {
        return ("" + rating).replace(".0", "");
    }

    public String generateUrlFrom(
        String currentUrl,
        String... addQueryParams
    ) {
        System.out.println("Previous query params : " + addQueryParams[0]);
        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(currentUrl);
        for (String queryParam : addQueryParams) {
            if (!queryParam.isEmpty()) {
                if (queryParam.contains("&")) { // existing old query param
                    String[] oldQueryParams = queryParam.split("&");
                    for (String oldQueryParamSplit : oldQueryParams) {
                        String[] parsed = oldQueryParamSplit.split("=");
                        url = addQueryParam(url, parsed[0], parsed[1]);
                    }
                } else {
                    String[] parsed = queryParam.split("=");
                    url = addQueryParam(url, parsed[0], parsed[1]);
                }
            }
        }
        return url.toUriString();
    }

    private UriComponentsBuilder addQueryParam(UriComponentsBuilder uri, String queryParamName, String queryParamValue) {
        return uri.replaceQueryParam(queryParamName, queryParamValue);
    }

}
