package tn.iit.matchService.response;

import java.util.Date;
import java.util.List;

import tn.iit.matchService.model.Match;
import tn.iit.matchService.model.Stadium;

public class MatchResponse {
	private long id;
	private Date date;
	private TeamResponse homeTeam;
	private TeamResponse awayTeam;
	private List<GoalResponse> goals;
	private RefereeResponse refree;
	private Stadium stadium;
	private int spectator;

	public MatchResponse(Match match, TeamResponse hTeamResponse, TeamResponse aTeamResponse, List<GoalResponse> goals,
			RefereeResponse referee) {
		this.id = match.getId();
		this.date = match.getDate();
		this.awayTeam = aTeamResponse;
		this.homeTeam = hTeamResponse;
		this.goals = goals;
		this.refree = referee;
		this.stadium = match.getStadium();
		this.spectator = match.getSpectator();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TeamResponse getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(TeamResponse homeTeam) {
		this.homeTeam = homeTeam;
	}

	public TeamResponse getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(TeamResponse awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public int getSpectator() {
		return spectator;
	}

	public void setSpectator(int spectator) {
		this.spectator = spectator;
	}

	public List<GoalResponse> getGoals() {
		return goals;
	}

	public void setGoals(List<GoalResponse> goals) {
		this.goals = goals;
	}

	public RefereeResponse getRefree() {
		return refree;
	}

	public void setRefree(RefereeResponse refree) {
		this.refree = refree;
	}
}
