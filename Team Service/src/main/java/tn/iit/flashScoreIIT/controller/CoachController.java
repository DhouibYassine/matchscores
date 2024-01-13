package tn.iit.flashScoreIIT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.flashScoreIIT.model.Coach;
import tn.iit.flashScoreIIT.service.CoachService;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping("")
    public List<Coach> getAll() {
        return coachService.findAll();
    }
    @GetMapping("/{id}")
    public Coach getById(@PathVariable long id) {
        return coachService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        coachService.delete(id);
    }
    @PostMapping("")
    public void save(@RequestBody Coach coach) {
        coachService.save(coach);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Coach coach) {
        coachService.update(coach, id);
    }
}
