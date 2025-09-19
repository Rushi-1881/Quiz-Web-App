package com.quizplatform.quiz_backend.dto;



public class SubmitResponseDto {
    private int score;
    private int totalQuestions;
    // optionally more

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public int getTotalQuestions() { return totalQuestions; }
    public void setTotalQuestions(int totalQuestions) { this.totalQuestions = totalQuestions; }
}
