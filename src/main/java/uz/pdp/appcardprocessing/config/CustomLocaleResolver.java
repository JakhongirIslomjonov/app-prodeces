package uz.pdp.appcardprocessing.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;
import java.util.Objects;

public class CustomLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = Objects.isNull(request.getHeader("X-Mobile-Lang")) ? "ru" : request.getHeader("X-Mobile-Lang");
        Locale locale = Locale.getDefault();

        if (StringUtils.hasText(language)) {
            locale = Locale.forLanguageTag(language);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
