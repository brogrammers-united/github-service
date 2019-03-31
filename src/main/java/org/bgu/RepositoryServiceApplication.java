package org.bgu;

import org.bgu.config.annotation.TheAppStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@TheAppStarter
public class RepositoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepositoryServiceApplication.class, args);
	}

}
