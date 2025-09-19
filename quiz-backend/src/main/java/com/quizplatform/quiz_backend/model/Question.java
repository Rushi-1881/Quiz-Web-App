package com.quizplatform.quiz_backend.model;



import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(length = 1000)
    private String questionText;

    private String option_A;
    private String option_B;
    private String option_C;
    private String option_D;

    private String correctOption;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public String getOptionA() { return option_A; }
    public void setOptionA(String optionA) { this.option_A = optionA; }
    public String getOptionB() { return option_B; }
    public void setOptionB(String optionB) { this.option_B = optionB; }
    public String getOptionC() { return option_C; }
    public void setOptionC(String optionC) { this.option_C = optionC; }
    public String getOptionD() { return option_D; }
    public void setOptionD(String optionD) { this.option_D = optionD; }
    public String getCorrectOption() { return correctOption; }
    public void setCorrectOption(String correctOption) { this.correctOption = correctOption; }
}
