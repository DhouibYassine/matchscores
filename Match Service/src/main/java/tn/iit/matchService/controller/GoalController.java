package tn.iit.matchService.controller;

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

import tn.iit.matchService.model.Goal;
import tn.iit.matchService.response.GoalResponse;
import tn.iit.matchService.service.GoalService;

@RestController
@RequestMapping("/goal")
public class GoalController {
	@Autowired
	private GoalService goalService;

	@GetMapping("")
	public List<GoalResponse> getAll() {
		return goalService.findAll();
	}

	@GetMapping("/{id}")
	public GoalResponse getById(@PathVariable long id) {
		return goalService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		goalService.delete(id);
	}

	@PostMapping("")
	public void save(@RequestBody Goal goal) {
		goalService.save(goal);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable long id, @RequestBody Goal goal) {
		goalService.update(goal, id);
	}

}
