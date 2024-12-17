package com.nillastudios.quizapp.quizapp;

import java.util.Arrays;

import com.nillastudios.quizapp.quizapp.model.Question;
import com.nillastudios.quizapp.quizapp.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizappApplication implements CommandLineRunner {

	@Autowired
	private QuestionRepository questionRepository;

	public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Seed initial data
		questionRepository.saveAll(Arrays.asList(
				new Question("What is the capital of France?", "Paris", "London", "Berlin", "Madrid", 1),
				new Question("What is the capital of Germany?", "Paris", "London", "Berlin", "Madrid", 3),
				new Question("Who is the prime minister of India?", "Donald Trump", "Jaishankar", "Narendra Modi",
						"Amit Shah", 3),
				new Question("What is the capital of India?", "Paris", "Delhi", "Berlin", "Madrid", 2),
				new Question("Which is the largest country in the world?", "Russia", "Canada", "China", "USA", 1)));
	}

}
