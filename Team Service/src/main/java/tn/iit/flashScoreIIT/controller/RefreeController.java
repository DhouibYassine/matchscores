package tn.iit.flashScoreIIT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.flashScoreIIT.model.Refree;
import tn.iit.flashScoreIIT.service.RefreeService;

import java.util.List;

@RestController
@RequestMapping("/refrees")
public class RefreeController {
    @Autowired
    private RefreeService refreeService;

    @GetMapping("")
    public List<Refree> getAll() {
        return refreeService.findAll();
    }
    @GetMapping("/{id}")
    public Refree getById(@PathVariable long id) {
        return refreeService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        refreeService.delete(id);
    }
    @PostMapping("")
    public void save(@RequestBody Refree refree) {
        refreeService.save(refree);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Refree refree) {
        refreeService.update(refree, id);
    }
}
