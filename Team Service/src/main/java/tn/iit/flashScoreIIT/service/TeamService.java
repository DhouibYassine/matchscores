package tn.iit.flashScoreIIT.service;
import java.util.List;

import org.springframework.stereotype.Service;
import tn.iit.flashScoreIIT.exception.TeamNotFoundException;
import tn.iit.flashScoreIIT.model.Team;
import tn.iit.flashScoreIIT.repository.TeamDao;

@Service
public class TeamService {
    private TeamDao teamDao;

    public TeamService(TeamDao teamDao) {
        this.teamDao = teamDao;
    }
    public List<Team> findAll() {
        return teamDao.findAll();
    }
    public Team findById(Long id) {
        return teamDao.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }
    public void save(Team teamToSave) {
        teamDao.save(teamToSave);
    }
    public void delete(Long id) {
        teamDao.deleteById(id);
    }
    public void update( Team newTeam, Long id) {
        Team team = findById(id);
        team.setName(newTeam.getName());
        team.setCoach(newTeam.getCoach());
        team.setPlayers(newTeam.getPlayers());
        teamDao.save(team);
    }
}
