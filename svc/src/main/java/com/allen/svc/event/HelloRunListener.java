package com.allen.svc.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @date 2020/11/18
 */

public class HelloRunListener implements SpringApplicationRunListener, Ordered {

    private SpringApplication application;
    private String[] args;

    public HelloRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }



    @Override
    public void starting() {
        ApplicationStartingEvent startingEvent = new ApplicationStartingEvent(this.application, this.args);
        System.out.println("Hello Run Listener .... Starting");

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        new ApplicationEnvironmentPreparedEvent(this.application, this.args, environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        new ApplicationContextInitializedEvent(this.application, this.args, context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        for (ApplicationListener<?> listener : this.application.getListeners()) {
            if (listener instanceof ApplicationContextAware) {
                ((ApplicationContextAware) listener).setApplicationContext(context);
            }
            context.addApplicationListener(listener);
        }
//        this.initialMulticaster.multicastEvent(new ApplicationPreparedEvent(this.application, this.args, context));
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        context.publishEvent(new ApplicationStartedEvent(this.application, this.args, context));
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        context.publishEvent(new ApplicationReadyEvent(this.application, this.args, context));
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        ApplicationFailedEvent event = new ApplicationFailedEvent(this.application, this.args, context, exception);
        if (context != null && context.isActive()) {
            // Listeners have been registered to the application context so we should
            // use it at this point if we can
            context.publishEvent(event);
        }
        else {
            // An inactive context may not have a multicaster so we use our multicaster to
            // call all of the context's listeners instead
            if (context instanceof AbstractApplicationContext) {
                for (ApplicationListener<?> listener : ((AbstractApplicationContext) context)
                        .getApplicationListeners()) {
//                    this.initialMulticaster.addApplicationListener(listener);
                }
            }
//            this.initialMulticaster.setErrorHandler(new EventPublishingRunListener.LoggingErrorHandler());
//            this.initialMulticaster.multicastEvent(event);
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 8;
    }
}
