package tn.iit.matchService.response;

import tn.iit.matchService.model.Goal;

public class GoalResponse {
	private long id;
	private PlayerResponse scorer;
	private int minute;

	public GoalResponse(Goal goal, PlayerResponse player) {
		this.id = goal.getId();
		this.scorer = player;
		this.minute = goal.getMinute();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PlayerResponse getScorer() {
		return scorer;
	}

	public void setScorer(PlayerResponse scorer) {
		this.scorer = scorer;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
}
