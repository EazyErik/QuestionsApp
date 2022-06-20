package com.example.questionsapp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/questions")
@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public List<Question> findAllQuestions() {
        return quizService.findAllQuestions();
    }
    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return quizService.createQuestion(question);
    }

    @GetMapping("/{id}")
    public Question findOneQuestion(@PathVariable String id) {
        return quizService.findOneQuestion(id);
    }
//    @DeleteMapping("{id")
//    public Question deleteOneQuestion() {
//        re
//    }





}
