package com.vesta.common.intercept;

import com.vesta.common.parse.ApiParseParam;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class ApiBeforeIntercept implements HandlerInterceptor {


    private static final String forward_url = "/vesta/api/query";

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        ApiParseParam.parse(request);
        request.getRequestDispatcher(forward_url).forward(request, response);
        return false;
    }


    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}", modelAndView);
    }


}
