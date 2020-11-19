package com.allen.svc.annotation;

import com.allen.svc.config.HelloConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @date 2020/11/16
 */

public class HelloImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.allen.svc.config.HelloConfiguration"};
    }
}
