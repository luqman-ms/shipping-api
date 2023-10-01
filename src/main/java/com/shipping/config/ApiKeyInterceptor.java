package com.shipping.config;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
class ApiKeyInterceptor implements HandlerInterceptor {

    private final Set<String> validApiKeys;

    public ApiKeyInterceptor(Set<String> validApiKeys) {
        this.validApiKeys = validApiKeys;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String apiKey = request.getHeader("X-Api-Key");
        String requestUrl = request.getServletPath();

        //bypass swagger ui
        if (requestUrl.startsWith("/swagger") || requestUrl.equals("/v2/api-docs")) {
            apiKey = "Ky4OZCyLwVVMrSbhuBRr5xtgxubeP59o";
        }

        if (apiKey != null && validApiKeys.contains(apiKey)) {
            return true;
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Unauthorized - Invalid API Key");
            return false; // API key is invalid
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // This method is called after the controller's method is invoked but before the
        // view is rendered.
        // You can perform post-processing here.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        // This method is called after the view is rendered.
        // You can perform cleanup or logging here.
    }
}
