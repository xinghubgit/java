package com.allen.svc.annotation;

import com.allen.svc.config.HelloConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author allen.jin
 * @date 2020/11/16
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Import(HelloConfiguration.class)
@Import(HelloImportSelector.class)
public @interface EnableHello {
}
