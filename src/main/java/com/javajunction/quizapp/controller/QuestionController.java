package com.javajunction.quizapp.controller;

import com.javajunction.quizapp.model.Question;
import com.javajunction.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return service.getAllQuestions();
    }

    @PostMapping("loadAll")
    public String loadAll(){
        service.load();
        return "Load Successfully";
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable("category") String category){
        return service.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public Question addQuestion(@RequestBody Question question){
        return service.addQuestion(question);
    }
}
