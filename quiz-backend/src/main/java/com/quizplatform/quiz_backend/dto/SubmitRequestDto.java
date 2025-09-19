package com.quizplatform.quiz_backend.dto;


import java.util.List;

public class SubmitRequestDto {
    private List<Answer> answers;
    private String userName;
    private Long timeTakenSeconds;

    public static class Answer {
        private Long questionId;
        private String selectedOption;
        // getters and setters
        public Long getQuestionId() { return questionId; }
        public void setQuestionId(Long questionId) { this.questionId = questionId; }
        public String getSelectedOption() { return selectedOption; }
        public void setSelectedOption(String selectedOption) { this.selectedOption = selectedOption; }
    }

    // getters & setters
    public List<Answer> getAnswers() { return answers; }
    public void setAnswers(List<Answer> answers) { this.answers = answers; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public Long getTimeTakenSeconds() { return timeTakenSeconds; }
    public void setTimeTakenSeconds(Long timeTakenSeconds) { this.timeTakenSeconds = timeTakenSeconds; }
}
