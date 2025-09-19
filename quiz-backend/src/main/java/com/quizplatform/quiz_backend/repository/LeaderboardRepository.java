package com.quizplatform.quiz_backend.repository;


import com.quizplatform.quiz_backend.model.LeaderboardEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaderboardRepository extends JpaRepository<LeaderboardEntry, Long> {
    List<LeaderboardEntry> findTop10ByQuizIdOrderByScoreDesc(Long quizId);
}
