package com.homeland.homeland;

import com.homeland.homeland.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class HomelandApplication implements CommandLineRunner {

	private final ImageService imageService;

	public static void main(String[] args) {
		SpringApplication.run(HomelandApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		imageService.init();
	}
}
