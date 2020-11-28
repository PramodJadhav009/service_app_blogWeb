
package com.blog.blogservice.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.blog.blogservice.exception.InternalServerErrorException;

@Log4j2
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Configuration
@ConfigurationProperties(prefix = "cloud.aws")
public class AWSCloudProperties {

  public static final String DEFAULT_RESOURCE = "default";
  
  @Builder.Default private Map<String, ServiceAccount> sa = new HashMap<>();
  @Builder.Default private Map<String, DynamoDBProperties> dynamoDb = new HashMap<>();

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class ServiceAccount {
    /** Configures a region for the application or the resource. */
    private String region;

    /** Configures a IAM user credentials. */
    private ServiceAccountCredentials credentials;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class DynamoDBProperties {
    /** Configures the DynamoDB endpoint */
    private String endpoint;

    /** Configures the DynamoDB table name. */
    private String tableName;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class ServiceAccountCredentials {
    /** The IAM user access key. */
    private String accessKey;

    /** The IAM user secret key. */
    private String secretKey;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class ClientCredentials {
    /** The IAM user access key. */
    private String clientId;

    /** The IAM user secret key. */
    private String clientSecret;
  }

  /**
   * Recovers the default region for the service. Eg: us-east-1.
   *
   * @return The region.
   */
  public String getRegion() {
    log.traceEntry("getRegion()");

    checkDefaultServiceAccount();

    if (Objects.isNull(sa.get(DEFAULT_RESOURCE).getRegion())) {
      throw log.throwing(
          new InternalServerErrorException(
              "Missing the 'cloud.aws.default.region' configuration for the service."));
    }

    return log.traceExit("getRegion(): {}", sa.get(DEFAULT_RESOURCE).getRegion());
  }

  /**
   * Recovers the the configured region for the given service account. Eg: us-east-1.
   *
   * @param resource The Service Account resource name
   * @return The region.
   */
  public String getRegion(String resource) {
    log.traceEntry("getRegion(resource={})", resource);

    if (!sa.containsKey(resource) || Objects.isNull(sa.get(resource).getRegion())) {
      return log.traceExit("getRegion(resource): {}", getRegion());
    }

    return log.traceExit("getRegion(resource): {}", sa.get(resource).getRegion());
  }

  /**
   * Recovers the IAM user's access key for the service.
   *
   * @return The access key.
   */
  public String getAccessKey() {
    log.traceEntry("getAccessKey()");

    checkDefaultServiceAccount();

    if (Objects.isNull(sa.get(DEFAULT_RESOURCE).getCredentials())) {
      throw log.throwing(
          new InternalServerErrorException(
              "Missing the 'cloud.aws.default.credentials' configuration for the service."));
    }

    if (Objects.isNull(sa.get(DEFAULT_RESOURCE).getCredentials().getAccessKey())) {
      throw log.throwing(
          new InternalServerErrorException(
              "Missing the 'cloud.aws.default.credentials.accessKey' configuration for the service."));
    }

    return log.traceExit(
        "getAccessKey(): {}", sa.get(DEFAULT_RESOURCE).getCredentials().getAccessKey());
  }

  /**
   * Recovers the IAM user's access key for the resource.
   *
   * @param resource The Service Account resource name
   * @return The access key.
   */
  public String getAccessKey(String resource) {
    log.traceEntry("getAccessKey(resource={})", resource);

    if (!sa.containsKey(resource) || Objects.isNull(sa.get(resource).getCredentials())) {
      return log.traceExit("getAccessKey(resource): {}", getAccessKey());
    }

    if (Objects.nonNull(sa.get(resource).getCredentials())
        && Objects.isNull(sa.get(resource).getCredentials().getAccessKey())) {
      throw log.throwing(
          new InternalServerErrorException(
              String.format(
                  "Missing 'cloud.aws.%s.credentials.accessKey' for the resource %s.",
                  resource, resource)));
    }

    return log.traceExit(
        "getAccessKey(resource): {}", sa.get(resource).getCredentials().getAccessKey());
  }

  /**
   * Recovers the IAM user's secret key for the service.
   *
   * @return The secret key.
   */
  public String getSecretKey() {
    log.traceEntry("getSecretKey()");

    checkDefaultServiceAccount();

    if (Objects.isNull(sa.get(DEFAULT_RESOURCE).getCredentials())) {
      throw log.throwing(
          new InternalServerErrorException(
              "Missing the 'cloud.aws.default.credentials' configuration for the service."));
    }

    if (Objects.isNull(sa.get(DEFAULT_RESOURCE).getCredentials().getSecretKey())) {
      throw log.throwing(
          new InternalServerErrorException(
              "Missing the 'cloud.aws.default.credentials.secretKey' configuration for the service."));
    }

    return log.traceExit(
        "getSecretKey(): {}", sa.get(DEFAULT_RESOURCE).getCredentials().getSecretKey());
  }

  /**
   * Recovers the IAM user's secret key for the resource.
   *
   * @param resource The Service Account resource name
   * @return The secret key.
   */
  public String getSecretKey(String resource) {
    log.traceEntry("getSecretKey(resource={})", resource);

    if (!sa.containsKey(resource) || Objects.isNull(sa.get(resource).getCredentials())) {
      return log.traceExit("getSecretKey(resource): {}", getSecretKey());
    }

    if (Objects.nonNull(sa.get(resource).getCredentials())
        && Objects.isNull(sa.get(resource).getCredentials().getSecretKey())) {
      throw log.throwing(
          new InternalServerErrorException(
              String.format(
                  "Missing 'cloud.aws.%s.credentials.secretKey' for the resource %s.",
                  resource, resource)));
    }

    return log.traceExit(
        "getSecretKey(resource): {}", sa.get(resource).getCredentials().getSecretKey());
  }

  /** Check if the service's service account credentials and is defined. */
  private void checkDefaultServiceAccount() {
    log.traceEntry("checkDefaultServiceAccount()");

    // If there aren't any default configuration set throws exception.
    if (!sa.containsKey(DEFAULT_RESOURCE)) {
      throw log.throwing(
          new InternalServerErrorException(
              "Missing the 'cloud.aws.default' configurations for the service."));
    }

    log.traceExit("checkDefaultServiceAccount(): {}");
  }

  /**
   * Recovers the table name for the given Dynamo DB resource.
   *
   * @param resource The Dynamo DB resource name
   * @return Table name
   */
  public String getTableName(String resource) {
    log.traceEntry("getTableName(resource={})", resource);

    if (!dynamoDb.containsKey(resource) || Objects.isNull(dynamoDb.get(resource).getTableName())) {
      throw log.throwing(
          new InternalServerErrorException(
              String.format(
                  "Missing the 'cloud.aws.dynamodb.<your-resource>.tableName' configurations for the resource=%s",
                  resource)));
    }

    return log.traceExit("getTableName(): {}", dynamoDb.get(resource).getTableName());
  }

   
  }
