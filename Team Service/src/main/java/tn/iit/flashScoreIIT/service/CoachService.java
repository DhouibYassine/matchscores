package tn.iit.flashScoreIIT.service;

import org.springframework.stereotype.Service;
import tn.iit.flashScoreIIT.exception.CoachNotFoundException;
import tn.iit.flashScoreIIT.model.Coach;
import tn.iit.flashScoreIIT.repository.CoachDao;
import java.util.List;

@Service
public class CoachService {
    private CoachDao coachDao;

    public CoachService(CoachDao CoachDao) {
        this.coachDao = CoachDao;
    }
    public List<Coach> findAll() {
        return coachDao.findAll();
    }
    public Coach findById(Long id) {
        return coachDao.findById(id).orElseThrow(() -> new CoachNotFoundException(id));
    }
    public void save(Coach coachToSave) {
        coachDao.save(coachToSave);
    }
    public void delete(Long id) {
        coachDao.deleteById(id);
    }
    public void update( Coach newCoach, Long id) {
        Coach coach = findById(id);
        coach.setName(newCoach.getName());
        coach.setAge(newCoach.getAge());
        coach.setTeam(newCoach.getTeam());
        coachDao.save(coach);
    }
}
