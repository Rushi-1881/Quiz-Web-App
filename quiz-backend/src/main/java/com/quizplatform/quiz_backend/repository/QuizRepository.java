package com.quizplatform.quiz_backend.repository;

import com.quizplatform.quiz_backend.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
