package com.kakaofriends.front.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Component
public class  LocaleUtils {

    public String whereAreYou() {
        Locale locale = (Locale)session().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME) == null ?
                Locale.KOREA : (Locale)session().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME) ;
        return locale.getCountry().toLowerCase().equals("kr") ? "kr" : "en";
    }

    /**
     * locale 변경.. 추가 2017.11.26 Breeze
     */
    public void changeWhereYouAre() {
        Locale locale = (Locale)session().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME) == null ?
                Locale.KOREA : (Locale)session().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME) ;

        if(locale.equals(Locale.KOREA)) {
            locale = Locale.ENGLISH;
        } else {
            locale = Locale.KOREA;
        }
        session().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
    }

    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(false); // true == allow create
    }
}