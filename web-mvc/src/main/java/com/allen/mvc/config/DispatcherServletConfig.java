package com.allen.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @date 2020/11/20
 */

@Configuration
@ComponentScan(basePackages = "com.allen.mvc")
public class DispatcherServletConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(DispatcherServletConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic registration = servletContext.addServlet("mvc", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping( new String[]{"/"});
    }
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        return null;
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{MvcConfig.class.getName()};
//    }
//
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        return null;
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//    }
}
