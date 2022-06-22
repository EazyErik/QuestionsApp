package com.example.questionsapp;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "devQuiz")
public class Question {


    @Id
    private String id;
    private String question;
    private String answer;
    private boolean approved;


    public Question(String question, String answer, boolean approved) {
        this.question = question;
        this.answer = answer;
        this.approved = approved;


    }
}
