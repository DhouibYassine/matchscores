package tn.iit.matchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.matchService.Exeption.MatchNotFoundException;
import tn.iit.matchService.feign.PlayerFeignClient;
import tn.iit.matchService.feign.RefereeFeignClient;
import tn.iit.matchService.feign.TeamFeignClient;
import tn.iit.matchService.model.Goal;
import tn.iit.matchService.model.Match;
import tn.iit.matchService.repository.MatchDao;
import tn.iit.matchService.response.GoalResponse;
import tn.iit.matchService.response.MatchResponse;
import tn.iit.matchService.response.RefereeResponse;
import tn.iit.matchService.response.TeamResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    MatchDao matchDao;

    @Autowired
    PlayerFeignClient playerFeignClient;

    @Autowired
    TeamFeignClient teamFeignClient;

    @Autowired
    RefereeFeignClient refereeFeignClient;

    @Autowired
    GoalService goalService;

    public List<MatchResponse> findAll() {
        List<Match> matchs = this.matchDao.findAll();
        List<MatchResponse> matchsResponse = new ArrayList<>();
        for (Match match : matchs) {
            TeamResponse hTeamResponse = this.teamFeignClient.getById(match.getAwayTeam());
            TeamResponse ATeamResponse = this.teamFeignClient.getById(match.getHomeTeam());
            List<GoalResponse> goals = new ArrayList<>();
            if (!match.getGoals().isEmpty()) {
                for (Goal goal : match.getGoals()) {
                    goals.add(this.goalService.findById(goal.getId()));
                }
            }

            RefereeResponse referee = this.refereeFeignClient.getById(match.getRefree());
            matchsResponse.add(new MatchResponse(match, hTeamResponse, ATeamResponse, goals, referee));

        }
        return matchsResponse;
    }

    public MatchResponse findById(long id) {
        Match match = this.matchDao.findById(id).orElseThrow(() -> new MatchNotFoundException(id));
        TeamResponse hTeamResponse = this.teamFeignClient.getById(match.getAwayTeam());
        TeamResponse ATeamResponse = this.teamFeignClient.getById(match.getHomeTeam());
        List<GoalResponse> goals = new ArrayList<>();
        if (!match.getGoals().isEmpty()) {
            for (Goal goal : match.getGoals()) {
                goals.add(this.goalService.findById(goal.getId()));
            }
        }

        RefereeResponse referee = this.refereeFeignClient.getById(match.getRefree());
        MatchResponse matchResponse = new MatchResponse(match, hTeamResponse, ATeamResponse, goals, referee);
        return matchResponse;
    }

    public void delete(long id) {
        this.matchDao.deleteById(id);

    }

    public void save(Match match) {


        this.matchDao.save(match);
    }

    public void update(Match newMatch, long id) {
        Match match = this.matchDao.findById(id).orElseThrow(() -> new MatchNotFoundException(id));

        this.matchDao.save(match);
    }

    public List<MatchResponse> getMatchByMatchDayId(Long id) {
        List <Match> matchs = this.matchDao.getMatchesByMatchDay(id);
        List<MatchResponse> matchsResponse = new ArrayList<>();
        for (Match match : matchs) {
            TeamResponse hTeamResponse = this.teamFeignClient.getById(match.getAwayTeam());
            TeamResponse ATeamResponse = this.teamFeignClient.getById(match.getHomeTeam());
            List<GoalResponse> goals = new ArrayList<>();
            if (!match.getGoals().isEmpty()) {
                for (Goal goal : match.getGoals()) {
                    goals.add(this.goalService.findById(goal.getId()));
                }
            }

            RefereeResponse referee = this.refereeFeignClient.getById(match.getRefree());
            matchsResponse.add(new MatchResponse(match, hTeamResponse, ATeamResponse, goals, referee));
        }
        return matchsResponse;
    }

}
