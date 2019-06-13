package kr.ac.sejong.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/bower_components/**")
                .addResourceLocations("/resources/bower_components/")
                .setCachePeriod(20);

        registry.addResourceHandler("/plugins/**")
                .addResourceLocations("/resources/plugins/")
                .setCachePeriod(20);

        registry.addResourceHandler("/dist/**")
                .addResourceLocations("/resources/dist/")
                .setCachePeriod(20);

        registry.addResourceHandler("/track_js/**")
                .addResourceLocations("/resources/track_js/")
                .setCachePeriod(20);
    }
}

