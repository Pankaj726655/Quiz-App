package com.javajunction.quizapp.controller;

import com.javajunction.quizapp.model.Question;
import com.javajunction.quizapp.model.QuestionWrapper;
import com.javajunction.quizapp.model.Response;
import com.javajunction.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
    return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
        public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
            return quizService.getQuizQuestions(id);
        }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> response){
        return quizService.calculateResult(id, response);
    }

}
