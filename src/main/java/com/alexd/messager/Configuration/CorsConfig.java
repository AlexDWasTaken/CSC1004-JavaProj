package com.alexd.messager.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//Configuration for CORS strategy.
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public  void  addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:5173")
                .allowedHeaders("*")
                .allowedMethods("*");
    }
}