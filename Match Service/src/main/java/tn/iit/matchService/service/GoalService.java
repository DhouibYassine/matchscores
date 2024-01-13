package tn.iit.matchService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.matchService.Exeption.GoalNotFoundException;
import tn.iit.matchService.feign.PlayerFeignClient;
import tn.iit.matchService.model.Goal;
import tn.iit.matchService.repository.GoalDao;
import tn.iit.matchService.response.GoalResponse;
import tn.iit.matchService.response.PlayerResponse;

@Service
public class GoalService {

	@Autowired
	GoalDao goalDao;

	@Autowired
	PlayerFeignClient playerFeignClient;

	public List<GoalResponse> findAll() {
		List<Goal> goals = this.goalDao.findAll();
		List<GoalResponse> goalResponses = new ArrayList<>();
		for (Goal goal : goals) {
			PlayerResponse player = this.playerFeignClient.getById(goal.getScorer());
			goalResponses.add(new GoalResponse(goal, player));
		}
		return goalResponses;
	}

	public GoalResponse findById(long id) {
		Goal goal = this.goalDao.findById(id).orElseThrow(() -> new GoalNotFoundException(id));
		PlayerResponse player = this.playerFeignClient.getById(goal.getScorer());
		return new GoalResponse(goal, player);
	}

	public void delete(long id) {
		this.goalDao.deleteById(id);

	}

	public void save(Goal goal) {
		this.goalDao.save(goal);

	}

	public void update(Goal newGoal, long id) {
		Goal goal = this.goalDao.findById(id).orElseThrow(() -> new GoalNotFoundException(id));
		goal.setMinute(newGoal.getMinute());
		goal.setScorer(newGoal.getScorer());
		this.goalDao.save(goal);
	}

}
