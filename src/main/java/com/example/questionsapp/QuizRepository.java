package com.example.questionsapp;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends MongoRepository<Question,String> {

    List<Question>findAllByApproved(boolean isApproved);



}
