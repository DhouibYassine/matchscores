package tn.iit.matchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.matchService.model.Match;

import java.util.List;

public interface MatchDao extends JpaRepository<Match, Long> {

    public List<Match> getMatchesByMatchDay(Long matchDay);

}
