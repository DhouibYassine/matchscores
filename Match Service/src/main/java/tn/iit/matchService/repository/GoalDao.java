package tn.iit.matchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.matchService.model.Goal;

public interface GoalDao extends JpaRepository<Goal, Long> {

}
