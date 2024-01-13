package tn.iit.flashScoreTn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.flashScoreTn.DAO.MatchDayDao;
import tn.iit.flashScoreTn.exceptions.MatchDayNotFoundException;
import tn.iit.flashScoreTn.feign.MatchFeignClient;
import tn.iit.flashScoreTn.models.MatchDay;
import tn.iit.flashScoreTn.response.MatchDayResponse;
import tn.iit.flashScoreTn.response.MatchResponse;

import java.util.ArrayList;
import java.util.List;


@Service
public class MatchDayService {

    @Autowired
    MatchDayDao matchDayDao;

    @Autowired
    MatchFeignClient matchFeignClient ;


    public List<MatchDayResponse> findAll(){
        List<MatchDay> matchDaysList = this .matchDayDao.findAll();
        List<MatchDayResponse> matchDayResponseList = new ArrayList<>() ;

        for (MatchDay matchDay: matchDaysList) {
            List<MatchResponse> matches = this.matchFeignClient.getAll(matchDay.getId());
            matchDayResponseList.add(new MatchDayResponse(matchDay,matches));
        }

        return matchDayResponseList;
    }

    public MatchDayResponse findById(Long id){
        MatchDay matchDay = this.matchDayDao.findById(id).orElseThrow(() -> new MatchDayNotFoundException(id));
        List<MatchResponse> matches = this.matchFeignClient.getAll(id);
        return new MatchDayResponse(matchDay,matches);
    }

    public void create(MatchDay matchDay) {
        this.matchDayDao.save(matchDay);

    }

    public void update(MatchDay matchDay, long id) {
        MatchDay matchDays = this.matchDayDao.findById(id).orElseThrow(() -> new MatchDayNotFoundException(id));
        matchDay.setStartDate(matchDays.getStartDate());
        matchDay.setEndDate(matchDays.getEndDate());
        matchDay.setSeason(matchDays.getSeason());
        this.matchDayDao.save(matchDay);
    }

    public void delete(long id) {
        this.matchDayDao.deleteById(id);

    }





}