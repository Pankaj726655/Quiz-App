package com.javajunction.quizapp.repo;

import com.javajunction.quizapp.model.Question;
import com.javajunction.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}
