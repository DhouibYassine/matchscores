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

import tn.iit.matchService.model.Match;
import tn.iit.matchService.response.MatchResponse;
import tn.iit.matchService.service.MatchService;

@RestController
@RequestMapping("/match")
public class MatchController {
	@Autowired
	private MatchService matchService;

	@GetMapping("")
	public List<MatchResponse> getAll() {
		return matchService.findAll();
	}

	@GetMapping("/{id}")
	public MatchResponse getById(@PathVariable long id) {
		return matchService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		matchService.delete(id);
	}

	@PostMapping("")
	public void save(@RequestBody Match match) {
		matchService.save(match);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable long id, @RequestBody Match match) {
		matchService.update(match, id);
	}

	@GetMapping("/matchday/{id}")
	public List<MatchResponse> getMatchByMatchDayId(@PathVariable Long id) {
		return matchService.getMatchByMatchDayId(id);
	}

}
