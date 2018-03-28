package com.ross53.cobar.localservice;

import com.ross53.cobar.localservice.service.ItemUpdateTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Timer;

@SpringBootApplication
public class LocalserviceApplication {

	@Component
	static class runner implements CommandLineRunner {

		@Autowired
		ItemUpdateTimer itemUpdateTimer;

		@Override
		public void run(String... args) throws Exception {

			System.out.println("retry running...");

			Timer timer = new Timer();

			timer.schedule(itemUpdateTimer,20000,10000);
		}
	}

		public static void main(String[] args) {

			SpringApplication app = new SpringApplication(LocalserviceApplication.class);
			app.setBannerMode(Banner.Mode.OFF);
			app.setWebEnvironment(false);
			app.run(args);
		}
}

