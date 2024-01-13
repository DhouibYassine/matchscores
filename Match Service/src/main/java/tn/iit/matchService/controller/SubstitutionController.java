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

import tn.iit.matchService.model.Substitution;
import tn.iit.matchService.response.SubstitutionResponse;
import tn.iit.matchService.service.SubstitutionService;

@RestController
@RequestMapping("/substitution")
public class SubstitutionController {
	@Autowired
	private SubstitutionService substitutionService;

	@GetMapping("")
	public List<SubstitutionResponse> getAll() {
		return substitutionService.findAll();
	}

	@GetMapping("/{id}")
	public SubstitutionResponse getById(@PathVariable long id) {
		return substitutionService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		substitutionService.delete(id);
	}

	@PostMapping("")
	public void save(@RequestBody Substitution substitution) {
		substitutionService.save(substitution);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable long id, @RequestBody Substitution substitution) {
		substitutionService.update(substitution, id);
	}

}
