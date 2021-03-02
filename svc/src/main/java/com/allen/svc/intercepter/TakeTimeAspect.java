package com.allen.svc.intercepter;

import com.allen.svc.AllenUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @date 2020/12/8
 */

@Component
public class TakeTimeAspect {

    public Object process(ProceedingJoinPoint point, TakeTime costTime) throws Throwable {
        Logger logger = LoggerFactory.getLogger(point.getTarget().getClass());
        final long start = System.currentTimeMillis();
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Object[] method_args = point.getArgs();
        String[] parameterNames = methodSignature.getParameterNames();
        String parameters = logParam(parameterNames, method_args);
        String preName = method.getName();
        if (costTime != null && StringUtils.isNotEmpty(costTime.value())) {
            preName = costTime.value();
        }
        String username = AllenUtil.getUsername();
        logger.info("username={}, {} parameters=[{}]", username, preName,  parameters);
        Object proceed = point.proceed();
        long time = System.currentTimeMillis() - start;
        logger.info("username={}, {} cost:{}ms;", username, preName, time);
        return proceed;
    }

    private String logParam(String[] parameterNames, Object[] paramsArgsValue) {
        if (parameterNames == null || parameterNames.length == 0) {
            return "";
        }
        int len = parameterNames.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String name = parameterNames[i];
            Object value = paramsArgsValue[i];
            builder.append(name + "=");
            builder.append(Arrays.deepToString(new Object[]{value}));

            if (i < len - 1) {
                builder.append(",");
            }

        }
        return builder.toString();
    }

}
