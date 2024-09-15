package com.javajunction.quizapp.service;

import com.javajunction.quizapp.model.Question;
import com.javajunction.quizapp.model.Quiz;
import com.javajunction.quizapp.repo.QuestionRepo;
import com.javajunction.quizapp.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return  new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
