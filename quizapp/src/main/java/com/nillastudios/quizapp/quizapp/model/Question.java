package com.nillastudios.quizapp.quizapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(force = true)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("questionText")
    @Column(nullable = false)
    private String questionText;

    @JsonProperty("option1")
    @Column(nullable = false)
    private String option1;

    @JsonProperty("option2")
    @Column(nullable = false)
    private String option2;

    @JsonProperty("option3")
    @Column(nullable = false)
    private String option3;

    @JsonProperty("option4")
    @Column(nullable = false)
    private String option4;

    @JsonIgnore
    @Column(nullable = false)
    private int correctOptionIndex;

    public Question() {}

    public Question(String questionText, String option1, String option2, String option3, String option4, int correctOptionIndex) {
        this.questionText = questionText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctOptionIndex = correctOptionIndex;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}