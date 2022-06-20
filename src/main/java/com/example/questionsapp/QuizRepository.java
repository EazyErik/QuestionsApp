package com.example.questionsapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuizRepository {

    List<Question> allMyQuestions = new ArrayList<>();


    public List<Question> findAllQuestions() {
        return allMyQuestions;

    }

    public Question createQuestion(Question question) {
       allMyQuestions.add(question);
       return allMyQuestions.get(allMyQuestions.size() - 1);



    }

    public Question findOneQuestion(String id) {
        Question result = null;
       for(Question question:allMyQuestions) {
           if(question.equals(id)) {
               result = question;
           }
       }
       return result;
    }
}
