package com.allen.svc.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @date 2020/12/4
 */

@Slf4j
@Component
public class AllenIntercepter extends HandlerInterceptorAdapter {

    private StopWatch stopWatch = new StopWatch();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        stopWatch.start();
        HandlerMethod method = (HandlerMethod) handler;
        String simpleName = method.getBeanType().getSimpleName();
        String name = method.getMethod().getName();
//        log.info("[" + request.getMethod() + "]" + request.getRequestURI() + getParameters(request));

        log.info("{}:{}:[{}]:{}", new Object[]{simpleName, name, request.getMethod(), request.getRequestURI() + getParameters(request)});



        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        stopWatch.stop();
        System.out.println("=====complete===== Takes: " + stopWatch.getLastTaskTimeMillis() + " ms");

    }

    private String getParameters(HttpServletRequest request) {
        if (CollectionUtils.isEmpty(request.getParameterMap())) {
            return "";
        }
        StringBuffer posted = new StringBuffer();
        Enumeration<?> e = request.getParameterNames();
        if (e != null) {
            posted.append("?");
        }
        while (e.hasMoreElements()) {
            if (posted.length() > 1) {
                posted.append("&");
            }
            String curr = (String) e.nextElement();
            posted.append(curr + "=");
            if (curr.contains("password")
                    || curr.contains("pass")
                    || curr.contains("pwd")) {
                posted.append("*****");
            } else {
                posted.append(request.getParameter(curr));
            }
        }
//        String ip = request.getHeader("X-FORWARDED-FOR");
//        String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
//        if (ipAddr!=null && !ipAddr.equals("")) {
//            posted.append("&_psip=" + ipAddr);
//        }
        return posted.toString();
    }

    private String getRemoteAddr(HttpServletRequest request) {
        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
            log.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }
}
