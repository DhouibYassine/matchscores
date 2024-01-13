package tn.iit.matchService.response;

import tn.iit.matchService.model.Substitution;

public class SubstitutionResponse {
	private long id;
	private PlayerResponse playerIn;
	private PlayerResponse playerOut;
	private int minute;

	public SubstitutionResponse(Substitution substitution, PlayerResponse playerIn, PlayerResponse playerOut) {
		this.id = substitution.getId();
		this.playerIn = playerIn;
		this.playerOut = playerOut;
		this.minute = substitution.getMinute();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PlayerResponse getPlayerIn() {
		return playerIn;
	}

	public void setPlayerIn(PlayerResponse playerIn) {
		this.playerIn = playerIn;
	}

	public PlayerResponse getPlayerOut() {
		return playerOut;
	}

	public void setPlayerOut(PlayerResponse playerOut) {
		this.playerOut = playerOut;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

}
