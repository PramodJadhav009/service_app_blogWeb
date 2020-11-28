
package com.blog.blogservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Client;
import feign.Feign;
import feign.Logger;
import feign.error.AnnotationErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Feign configuration class. */
@Configuration
@EnableFeignClients
public class FeignConfig {
  private final ObjectMapper objectMapper;

  @Value("${log.feign.level:BASIC}")
  private String logLevel;

  /**
   * Setup a feign client.
   */
  @Autowired
  private Client client;

  @Autowired
  public FeignConfig(final ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  /**
   * Setup a http client for feign configs.
   *
   * @return http client
   */
  @Bean
  public OkHttpClient okHttpClient() {
    return new OkHttpClient();
  }
}
