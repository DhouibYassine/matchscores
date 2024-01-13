package tn.iit.flashScoreTn.response;


import java.util.Date;
import java.util.List;

public class MatchResponse {
    private long id;
    private Date date;
    private TeamResponse homeTeam;
    private TeamResponse awayTeam;
    private List<GoalResponse> goals;
    private RefereeResponse refree;
    private StadiumResponse stadium;
    private int spectator;

    @Override
    public String toString() {
        return "MatchResponse{" +
                "id=" + id +
                ", date=" + date +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", goals=" + goals +
                ", refree=" + refree +
                ", stadium=" + stadium +
                ", spectator=" + spectator +
                '}';
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

    public StadiumResponse getStadium() {
        return stadium;
    }

    public void setStadium(StadiumResponse stadium) {
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
