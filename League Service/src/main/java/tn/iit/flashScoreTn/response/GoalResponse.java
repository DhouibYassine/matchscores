package tn.iit.flashScoreTn.response;


public class GoalResponse {
	private long id;
	private PlayerResponse scorer;
	private int minute;


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
