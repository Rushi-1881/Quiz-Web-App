package com.quizplatform.quiz_backend.service;



import com.quizplatform.quiz_backend.model.*;
import com.quizplatform.quiz_backend.repository.*;
import com.quizplatform.quiz_backend.dto.*;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuizRepository quizRepo;
    private final QuestionRepository questionRepo;
    private final LeaderboardRepository leaderboardRepo;

    public QuizService(QuizRepository quizRepo, QuestionRepository questionRepo, LeaderboardRepository leaderboardRepo) {
        this.quizRepo = quizRepo;
        this.questionRepo = questionRepo;
        this.leaderboardRepo = leaderboardRepo;
    }

    public List<QuizDto> getAllQuizzes() {
        return quizRepo.findAll().stream()
            .map(q -> {
                QuizDto dto = new QuizDto();
                dto.setId(q.getId());
                dto.setTitle(q.getTitle());
                dto.setDescription(q.getDescription());
                return dto;
            })
            .collect(Collectors.toList());
    }

    public List<QuestionDto> getQuestionsByQuizId(Long quizId) {
        return questionRepo.findByQuiz_Id(quizId).stream()
            .map(q -> {
                QuestionDto dto = new QuestionDto();
                dto.setId(q.getId());
                dto.setQuestionText(q.getQuestionText());
                dto.setOptionA(q.getOptionA());
                dto.setOptionB(q.getOptionB());
                dto.setOptionC(q.getOptionC());
                dto.setOptionD(q.getOptionD());
                return dto;
            })
            .collect(Collectors.toList());
    }

    public SubmitResponseDto submitQuiz(Long quizId, SubmitRequestDto request) {
        List<Question> questions = questionRepo.findByQuiz_Id(quizId);
        int total = questions.size();
        int correct = 0;
        for (Question q : questions) {
            Optional<SubmitRequestDto.Answer> ans =
                request.getAnswers().stream()
                       .filter(a -> a.getQuestionId().equals(q.getId()))
                       .findFirst();
            if (ans.isPresent() && ans.get().getSelectedOption().equals(q.getCorrectOption())) {
                correct++;
            }
        }
        // save leaderboard entry
        LeaderboardEntry entry = new LeaderboardEntry();
        entry.setQuizId(quizId);
        entry.setUserName(request.getUserName());
        entry.setScore(correct);
        entry.setTimeTakenSeconds(request.getTimeTakenSeconds());
        leaderboardRepo.save(entry);

        SubmitResponseDto resp = new SubmitResponseDto();
        resp.setScore(correct);
        resp.setTotalQuestions(total);
        return resp;
    }

    public List<LeaderboardEntry> getLeaderboard(Long quizId) {
        return leaderboardRepo.findTop10ByQuizIdOrderByScoreDesc(quizId);
    }
}
