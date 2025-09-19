package com.quizplatform.quiz_backend.controller;



import com.quizplatform.quiz_backend.dto.*;
import com.quizplatform.quiz_backend.model.LeaderboardEntry;
import com.quizplatform.quiz_backend.service.QuizService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("")
    public List<QuizDto> listQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/{quizId}/questions")
    public List<QuestionDto> getQuestions(@PathVariable Long quizId) {
        return quizService.getQuestionsByQuizId(quizId);
    }

    @PostMapping("/{quizId}/submit")
    public SubmitResponseDto submitQuiz(
        @PathVariable Long quizId,
        @RequestBody SubmitRequestDto request) {
        return quizService.submitQuiz(quizId, request);
    }

    @GetMapping("/{quizId}/leaderboard")
    public List<LeaderboardEntry> leaderboard(@PathVariable Long quizId) {
        return quizService.getLeaderboard(quizId);
    }
}
