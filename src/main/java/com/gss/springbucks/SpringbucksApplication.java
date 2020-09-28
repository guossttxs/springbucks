package com.gss.springbucks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@Slf4j
public class SpringbucksApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbucksApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}

}
