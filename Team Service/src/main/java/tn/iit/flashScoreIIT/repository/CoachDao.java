package tn.iit.flashScoreIIT.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.flashScoreIIT.model.Coach;

public interface CoachDao extends JpaRepository<Coach, Long> {
}
