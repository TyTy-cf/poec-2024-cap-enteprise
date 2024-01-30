package fr.kevin.cap_enterprise.mapping;

public class UrlRoute {

    public final static String URL_LOGIN = "/login";
    public final static String URL_LOGOUT = "/logout";
    public final static String URL_REGISTER = "/s-inscrire";
    public final static String URL_USER = "/gamer";
    public final static String URL_EXPORT= "/telecharger-export-excel";

    public final static String URL_REVIEW = "/avis";
    public final static String URL_REVIEW_NEW = URL_REVIEW + "/nouveau";
    public final static String URL_REVIEW_MODERATE = URL_REVIEW + "/{id}/{moderate}";
    public final static String URL_REVIEW_ID = URL_REVIEW + "/avis/{id}";

    public final static String URL_GAME = "/jeu";
    public final static String URL_GAME_NEW = URL_GAME + "/nouveau";
    public final static String URL_GAME_SLUG = URL_GAME + "/{slug}";

}
