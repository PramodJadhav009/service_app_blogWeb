
package com.blog.blogservice.config;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
    final Optional<ObjectMapper> registeredObjectMapper = getRegisteredObjectMapper(converters);
    if (registeredObjectMapper.isPresent())
      setupObjectMapper(registeredObjectMapper.get());
    else
      converters.add(createJacksonConverter());
  }

  private MappingJackson2HttpMessageConverter createJacksonConverter() {
    final ObjectMapper mapper = new ObjectMapper();
    setupObjectMapper(mapper);
    return new MappingJackson2HttpMessageConverter(mapper);
  }

  private Optional<ObjectMapper> getRegisteredObjectMapper(
      final List<HttpMessageConverter<?>> converters) {
    return converters.stream().filter(c -> (c instanceof MappingJackson2HttpMessageConverter))
        .findFirst().map(MappingJackson2HttpMessageConverter.class::cast)
        .map(MappingJackson2HttpMessageConverter::getObjectMapper);
  }

  private void setupObjectMapper(final ObjectMapper objectMapper) {
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
  }

}
