package com.allen.svc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @date 2020/12/8
 */

@Slf4j
public class AllenUtil {
    public static String getUsername(){
        try {
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
            return request.getHeader("username");
        } catch (Exception e) {
            log.error("get username fail", e);
            return null;
        }
    }
}
