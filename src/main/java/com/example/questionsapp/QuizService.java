package com.example.questionsapp;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    public List<Question> findAllQuestions() {
        return quizRepository.findAllQuestions();
    }

    public Question createQuestion(Question question) {
         return quizRepository.createQuestion(question);
    }

    public Question findOneQuestion(String id) {
        return quizRepository.findOneQuestion(id);
    }
}
