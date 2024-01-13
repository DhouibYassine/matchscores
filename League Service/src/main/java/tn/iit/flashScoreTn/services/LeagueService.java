package tn.iit.flashScoreTn.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.flashScoreTn.DAO.LeagueDao;
import tn.iit.flashScoreTn.exceptions.LeagueNotFoundException;
import tn.iit.flashScoreTn.models.League;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    @Autowired
    LeagueDao leagueDao ;

    public List<League> findAll() {
        return this.leagueDao.findAll();
    }

    public League findById(long id) {
        return this.leagueDao.findById(id).orElseThrow(() -> new LeagueNotFoundException(id));
    }

    public void create(League league) {
        this.leagueDao.save(league);

    }

    public void update(League League, long id) {
        League league = findById(id);
        league.setName(League.getName());
        league.setSeason(league.getSeason());
        this.leagueDao.save(league);
    }

    public void delete(long id) {
        this.leagueDao.deleteById(id);

    }


}
