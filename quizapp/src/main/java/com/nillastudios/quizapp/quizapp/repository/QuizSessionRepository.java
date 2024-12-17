package com.nillastudios.quizapp.quizapp.repository;

import com.nillastudios.quizapp.quizapp.model.Question;
import com.nillastudios.quizapp.quizapp.model.QuizSession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {
}