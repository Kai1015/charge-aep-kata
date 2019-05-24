package com.kaiherrera.chargeaep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChargeAepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChargeAepApplication.class, args);
	}
	
	@Bean
    public RestTemplate getRestTemplate() {
       return new RestTemplate();
    }

}
