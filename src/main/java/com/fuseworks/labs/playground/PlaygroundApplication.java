package com.fuseworks.labs.playground;

import com.fuseworks.labs.playground.endless.EndlessService;
import com.fuseworks.labs.playground.endless.EndlessServiceImpl;
import com.fuseworks.labs.playground.endless.Photo;
import com.fuseworks.labs.playground.endless.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PlaygroundApplication implements CommandLineRunner {

	@Autowired
	EndlessServiceImpl endlessService;

	@Autowired
	PhotoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Photo> photos = endlessService.getPhotos();
		repository.save(photos);
	}
}
