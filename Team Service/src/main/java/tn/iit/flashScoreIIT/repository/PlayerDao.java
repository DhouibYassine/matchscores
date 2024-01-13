package tn.iit.flashScoreIIT.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.flashScoreIIT.model.Player;

import java.util.List;

public interface PlayerDao extends JpaRepository<Player, Long> {


}
