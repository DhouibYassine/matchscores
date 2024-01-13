package tn.iit.flashScoreTn.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.flashScoreTn.models.Season;

import java.util.List;

public interface SeasonDao extends JpaRepository <Season, Long> {

}
