package tn.iit.matchService.response;

import java.util.List;

public class TeamResponse {
	private Long id;
	private String name;
	private List<PlayerResponse> players;
	private CoachResponse coach;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PlayerResponse> getPlayers() {
		return players;
	}
	public void setPlayers(List<PlayerResponse> players) {
		this.players = players;
	}
	public CoachResponse getCoach() {
		return coach;
	}
	public void setCoach(CoachResponse coach) {
		this.coach = coach;
	}
	@Override
	public String toString() {
		return "TeamResponse [id=" + id + ", name=" + name + ", players=" + players + ", coach=" + coach + "]";
	}


}
