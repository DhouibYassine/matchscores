package tn.iit.flashScoreIIT.repository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.iit.flashScoreIIT.model.Team;

import java.util.List;

public interface TeamDao extends JpaRepository<Team, Long> {

}
