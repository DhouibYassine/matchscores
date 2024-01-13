package tn.iit.flashScoreTn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.flashScoreTn.DAO.SeasonDao;
import tn.iit.flashScoreTn.exceptions.SeasonNotFoundException;
import tn.iit.flashScoreTn.models.Season;

import java.util.List;

@Service
public class SeasonService {

    @Autowired
    SeasonDao seasonDao ;

    public List<Season> findAll(){
        return this.seasonDao.findAll();
    }

    public Season findById(long id){
        return this.seasonDao.findById(id).orElseThrow(() ->  new SeasonNotFoundException(id));
    }

    public void create (Season season){
        this.seasonDao.save(season);
    }

    public void update(long id , Season season){
        Season seasons = findById(id);
        seasons.setStartingDate(season.getStartingDate());
        seasons.setEndingDate(season.getEndingDate());
        seasons.setLeague(season.getLeague());
        seasons.setMatchDay(seasons.getMatchDay());

        this.seasonDao.save(seasons);
    }

    public void delete(long id){
        this.seasonDao.deleteById(id);
    }
}
