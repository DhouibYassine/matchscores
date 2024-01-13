package tn.iit.flashScoreTn.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.flashScoreTn.models.MatchDay;

public interface MatchDayDao extends JpaRepository<MatchDay, Long> {
}

