package tn.iit.matchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.matchService.model.Stadium;

public interface StadiumDao extends JpaRepository<Stadium, Long> {

}
