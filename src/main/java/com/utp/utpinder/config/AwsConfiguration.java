package com.utp.utpinder.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Agrega la anotación @Configuration
public class AwsConfiguration {

    @Bean
    public AmazonSimpleEmailServiceClient amazonSimpleEmailServiceClient(
            @Value("${cloud.aws.credentials.access-key}") String accessKey,
            @Value("${cloud.aws.credentials.secret-key}") String secretKey,
            @Value("${cloud.aws.region.static}") String region) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return new AmazonSimpleEmailServiceClient(credentials).withRegion(Regions.fromName(region));
    }


}
