package com.nillastudios.quizapp.quizapp.controller;

import com.nillastudios.quizapp.quizapp.model.Question;
import com.nillastudios.quizapp.quizapp.model.QuizSession;
import com.nillastudios.quizapp.quizapp.repository.QuestionRepository;
import com.nillastudios.quizapp.quizapp.repository.QuizSessionRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @GetMapping("/start")
    public ResponseEntity<QuizSession> startQuiz() {
        QuizSession session = new QuizSession();
        session.setTotalQuestions(0);
        session.setCorrectAnswers(0);
        session.setIncorrectAnswers(0);
        return ResponseEntity.ok(quizSessionRepository.save(session));
    }

    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion(@RequestParam(name = "sessionId") Long sessionId) {
        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        session.setCurrentQuestion(questionRepository.findRandomQuestion());
        quizSessionRepository.save(session);

        return ResponseEntity.ok(session.getCurrentQuestion());
    }

    @PostMapping("/submit")
    public ResponseEntity<QuizSession> submitAnswer(
            @RequestParam(name = "sessionId") Long sessionId,
            @RequestParam(name = "selectedOptionIndex") int selectedOptionIndex) {

        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        Question currentQuestion = session.getCurrentQuestion();
        session.setTotalQuestions(session.getTotalQuestions() + 1);

        if (selectedOptionIndex == currentQuestion.getCorrectOptionIndex()) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }

        // return quizSessionRepository.save(session);
        return ResponseEntity.ok(quizSessionRepository.save(session));
    }

    @GetMapping("/results")
    public ResponseEntity<QuizSession> getQuizResults(
            @RequestParam(name = "sessionId") Long sessionId) {
        return ResponseEntity.ok(quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found")));
    }
}
