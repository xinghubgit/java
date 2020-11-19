package com.allen.svc.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * @date 2020/11/17
 */

public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> multiValueMap = metadata.getAllAnnotationAttributes(ConditionalOnSystemProperties.class.getName());
        String name = String.valueOf(multiValueMap.get("name").get(0));
        String value = String.valueOf(multiValueMap.get("value").get(0));

        String sysValue = (String)System.getProperties().get(name);

        return value.equalsIgnoreCase(sysValue);
    }
}
