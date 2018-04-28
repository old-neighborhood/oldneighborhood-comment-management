package com.oldneighborhood.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan("com.oldneighborhood.demo")
public class OldneighborhoodCommentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OldneighborhoodCommentManagementApplication.class, args);
	}
}
