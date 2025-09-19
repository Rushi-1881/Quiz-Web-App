package com.quizplatform.quiz_backend.model;



import jakarta.persistence.*;

@Entity
public class LeaderboardEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private int score;
    private Long quizId;
    private Long timeTakenSeconds;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public Long getQuizId() { return quizId; }
    public void setQuizId(Long quizId) { this.quizId = quizId; }
    public Long getTimeTakenSeconds() { return timeTakenSeconds; }
    public void setTimeTakenSeconds(Long timeTakenSeconds) { this.timeTakenSeconds = timeTakenSeconds; }
}

