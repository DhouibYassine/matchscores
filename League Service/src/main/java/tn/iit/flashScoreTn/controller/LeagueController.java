package tn.iit.flashScoreTn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.flashScoreTn.models.League;
import tn.iit.flashScoreTn.services.LeagueService;

import java.util.List;

@RestController
@RequestMapping("/league")
public class LeagueController {

    @Autowired
    LeagueService leagueService;


    @GetMapping("")
    public List<League> getALl() {
        return this.leagueService.findAll();
    }

    @GetMapping("/{id}")
    public League getById(@PathVariable long id) {
        return this.leagueService.findById(id);
    }

    @PostMapping("")
    public void create(@RequestBody League league) {
        leagueService.create(league);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody League league) {
        leagueService.update(league, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        leagueService.delete(id);
    }
}
