package com.zzdz.consumersample;

import consumer.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ConsumerSampleApplication {

	@Reference(version = "${demo.service.version}")
	private DemoService demoService;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerSampleApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner() {
		return args -> log.info(demoService.sayHello("mercyblitz"));
	}

}
