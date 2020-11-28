
package com.blog.blogservice.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger Configuration Class
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

  /**
   * Method that generates the hadlers for swagger
   */
  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {

    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  /**
   * Method that generates the api info
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Blog Service")
        .description("This page lists all the rest endpoints for Blog Services.")
        .version("1.0-SNAPSHOT").build();
  }

  /**
   * Method that generates de api for the controllers
   */
  @Bean
  public Docket produceApi(@Value("${swagger.enabled}") final Boolean enabled) {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.basePackage("com.blog.blogservice.controller")).build()
        .enable(enabled);
  }

}
