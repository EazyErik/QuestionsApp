package com.example.questionsapp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Question> findQuestionById(@PathVariable String id) {
        return ResponseEntity.of(quizService.findQuestionById(id));
    }
    @PutMapping
    public ResponseEntity<Question> editQuestion(@RequestBody Question question) {
        return ResponseEntity.of(quizService.editQuestion(question));

    }



}
