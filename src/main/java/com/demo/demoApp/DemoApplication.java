package com.demo.demoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    public RestTemplate restTemplateBean(){

        return new RestTemplate();

    }

	// @Bean
	// public AWSServiceDiscovery awsServiceDiscovery() {

	// 	return AWSServiceDiscoveryClientBuilder.defaultClient();
	// }

	// @Bean
	// public AWSServiceDiscovery awsServiceDiscovery() {
	// 	//AWSCredentials credentials = new EC2ContainerCredentialsProviderWrapper().getCredentials();
        
	// 	return AWSServiceDiscoveryClientBuilder
	// 		.standard()
	// 		.withRegion(System.getenv("us-east-1"))
	// 		//.withCredentials(new AWSStaticCredentialsProvider(credentials))
	// 		.build();
	// }
	

}
