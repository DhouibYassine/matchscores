package tn.iit.flashScoreTn.response;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import tn.iit.flashScoreTn.models.MatchDay;
import tn.iit.flashScoreTn.models.Season;

import java.util.Date;
import java.util.List;

public class MatchDayResponse {

    Long id;

    Date startDate;
    Date endDate;
    Season season;

    List<MatchResponse> matches ;

    public MatchDayResponse(MatchDay matchDay, List<MatchResponse> matches) {

        this.matches=matches ;
        this.startDate = matchDay.getStartDate();
        this.endDate =matchDay.getEndDate() ;
        this.season = matchDay.getSeason();
        this.id = matchDay.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<MatchResponse> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchResponse> matches) {
        this.matches = matches;
    }
}
