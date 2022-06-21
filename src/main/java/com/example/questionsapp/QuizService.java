package com.example.questionsapp;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    public List<Question> findAllQuestions() {
        return quizRepository.findAllByApproved(true);
    }

    public Question createQuestion(Question question) {
         return quizRepository.save(question);
    }


    public Optional<Question> findQuestionById(String id) {
        return quizRepository.findById(id);
    }


    public Optional<Question> editQuestion(Question question) {
       Optional<Question> chosenQuestion = quizRepository.findById(question.getId());
       if(chosenQuestion.isPresent()){
           return Optional.of(quizRepository.save(question));
       }
       return Optional.empty();
    }
}
