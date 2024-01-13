package tn.iit.flashScoreTn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.flashScoreTn.models.MatchDay;
import tn.iit.flashScoreTn.response.MatchDayResponse;
import tn.iit.flashScoreTn.services.MatchDayService;

import java.util.List;


@RestController
@RequestMapping("/matchDay")
public class MatchDayController {


    @Autowired
    private MatchDayService matchDayService;

    @GetMapping("")
    public List<MatchDayResponse> getAll() {
        return matchDayService.findAll();
    }

    @GetMapping("/{id}")
    public MatchDayResponse grtById(@PathVariable long id){
        return matchDayService.findById(id);
    }

    @PostMapping("")
    public void create(@RequestBody MatchDay matchDay){
        this.matchDayService.create(matchDay);
    }

    @PutMapping("/{id}")
    public void update (@PathVariable long id , @RequestBody MatchDay matchDay){
        this.matchDayService.update(matchDay, id);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable long id ){
        this.matchDayService.delete(id);
    }
}
