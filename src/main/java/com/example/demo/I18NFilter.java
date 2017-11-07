package com.example.demo;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

@Order(1)
@WebFilter(filterName = "I18NFilter", urlPatterns = "/*")
public class I18NFilter implements Filter {
    private static final String COOKIE_LANGUAGE = "cookie_language";
    private static final String SYSTEM_LANGUAGE = "system_language";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("@doFilter===============================");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String systemLanguage = getSystemLanguage(httpServletRequest);
        servletRequest.setAttribute(SYSTEM_LANGUAGE, systemLanguage);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("@destroy===============================");
    }

    private String getSystemLanguage(HttpServletRequest request) {
        System.out.println("@getSystemLanguage===============================");
        String systemLanguage = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (COOKIE_LANGUAGE.equals(cookie.getName())) {
                    systemLanguage = cookie.getValue();
                    break;
                }
            }
        }

        if (systemLanguage == null || "".equals(systemLanguage)) {
            systemLanguage = request.getLocale().toString();
        }
        if (systemLanguage == null || "".equals(systemLanguage)) {
            systemLanguage = Locale.getDefault().toString();
        }
        return systemLanguage;
    }
}
