package tn.iit.flashScoreTn.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.flashScoreTn.models.League;

public interface LeagueDao extends JpaRepository<League,Long> {
}
