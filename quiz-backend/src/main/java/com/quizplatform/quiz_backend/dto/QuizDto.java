package com.quizplatform.quiz_backend.dto;



import java.util.List;

public class QuizDto {
    private Long id;
    private String title;
    private String description;
    // optionally: number of questions
    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
