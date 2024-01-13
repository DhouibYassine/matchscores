package tn.iit.flashScoreIIT.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.iit.flashScoreIIT.model.Team;
import tn.iit.flashScoreIIT.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("")
    public List<Team> getAll() {
        return teamService.findAll();
    }
    @GetMapping("/{id}")
    public Team getById(@PathVariable long id) {
        return teamService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        teamService.delete(id);
    }
    @PostMapping("")
    public void save(@RequestBody Team team) {
        teamService.save(team);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Team team) {
        teamService.update(team, id);
    }
}
