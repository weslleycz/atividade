package com.br.atividade.navigation;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WelcomePageRedirect implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("forward:/index.xhtml");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registry.addViewController("/adiconar")
                .setViewName("forward:/add.xhtml");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registry.addViewController("/edit")
        .setViewName("forward:/edit.xhtml");
        registry.addViewController("/criar")
        .setViewName("forward:/addDependente.xhtml");
    }
}