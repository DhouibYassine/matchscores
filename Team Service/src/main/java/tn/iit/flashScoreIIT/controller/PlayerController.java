package tn.iit.flashScoreIIT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.flashScoreIIT.model.Player;
import tn.iit.flashScoreIIT.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;


    @GetMapping("")
    public List<Player> getAll() {
        return playerService.findAll();
    }
    @GetMapping("/{id}")
    public Player getById(@PathVariable long id) {
        return playerService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        playerService.delete(id);
    }
    @PostMapping("")
    public void save(@RequestBody Player player) {
        playerService.save(player);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Player player) {
        playerService.update(player, id);
    }
}
