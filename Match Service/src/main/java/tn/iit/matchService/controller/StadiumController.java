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

import tn.iit.matchService.model.Stadium;
import tn.iit.matchService.service.StadiumService;

@RestController
@RequestMapping("/stadium")
public class StadiumController {
	@Autowired
	private StadiumService stadiumService;

	@GetMapping("")
	public List<Stadium> getAll() {
		return stadiumService.findAll();
	}

	@GetMapping("/{id}")
	public Stadium getById(@PathVariable long id) {
		return stadiumService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		stadiumService.delete(id);
	}

	@PostMapping("")
	public void save(@RequestBody Stadium stadium) {
		stadiumService.save(stadium);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable long id, @RequestBody Stadium stadium) {
		stadiumService.update(stadium, id);
	}

}
