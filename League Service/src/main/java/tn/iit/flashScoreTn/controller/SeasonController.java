package tn.iit.flashScoreTn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.flashScoreTn.models.Season;
import tn.iit.flashScoreTn.services.SeasonService;

import java.util.List;

@RestController
@RequestMapping("/season")
public class SeasonController {

    @Autowired
    SeasonService seasonService ;

    @GetMapping("")
    public List<Season> getAll(){
        return this.seasonService.findAll();
    }

    @GetMapping("/{id}")
    public Season getById(@PathVariable long id){
        return this.seasonService.findById(id);
    }

    @PostMapping("")
    public void create(@RequestBody Season season){
        this.seasonService.create(season);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id ,@RequestBody Season season){
        this.seasonService.update(id,season);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        this.seasonService.delete(id);
    }

}
