package com.blog.blogservice.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/** AWS configuration class. */
@Configuration
@Getter
@NoArgsConstructor
@EnableDynamoDBRepositories(basePackages = "com.lifescan.userservice.aws.repository")
public class AWSConfig {

  private AWSCloudProperties awsCloudProperties;

  @Autowired
  public AWSConfig(final AWSCloudProperties awsCloudProperties) {
    this.awsCloudProperties = awsCloudProperties;
  }

  /**
   * Returns the credentials to access DynamoDB resource.
   *
   * @return AWS credentials
   */
  @Bean
  public AWSCredentialsProvider amazonAWSCredentialsProvider() {
    return new AWSStaticCredentialsProvider(new BasicAWSCredentials(
        awsCloudProperties.getAccessKey(), awsCloudProperties.getSecretKey()));
  }

  /**
   * Returns DynamoDb bean.
   *
   * @return DynamoDB instance
   */
  @Bean
  public AmazonDynamoDB amazonDynamoDB() {
    return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
        .withEndpointConfiguration(new EndpointConfiguration(
            awsCloudProperties.getDynamoDb().get(AWSCloudProperties.DEFAULT_RESOURCE).getEndpoint(),
            awsCloudProperties.getRegion()))
        .build();
  }

  @Bean
  @Primary
  public DynamoDBMapperConfig getDynamoDBMapperConfig(
      final DynamoDBMapperConfig.TableNameOverride tableNameOverride) {
    final DynamoDBMapperConfig.Builder builder = new DynamoDBMapperConfig.Builder();
    builder.setTableNameOverride(tableNameOverride);
    builder.setTypeConverterFactory(DynamoDBTypeConverterFactory.standard());
    return builder.build();
  }

}
