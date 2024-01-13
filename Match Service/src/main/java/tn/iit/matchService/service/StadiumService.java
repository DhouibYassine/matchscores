package tn.iit.matchService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.matchService.Exeption.StadiumNotFoundException;
import tn.iit.matchService.model.Stadium;
import tn.iit.matchService.repository.StadiumDao;

@Service
public class StadiumService {
	@Autowired
	StadiumDao stadiumDao;

	public List<Stadium> findAll() {
		return this.stadiumDao.findAll();
	}

	public Stadium findById(long id) {
		return this.stadiumDao.findById(id).orElseThrow(() -> new StadiumNotFoundException(id));
	}

	public void delete(long id) {
		this.stadiumDao.deleteById(id);

	}

	public void save(Stadium stadium) {
		this.stadiumDao.save(stadium);

	}

	public void update(Stadium newStadium, long id) {
		Stadium stadium = findById(id);
		stadium.setCapacity(newStadium.getCapacity());
		stadium.setName(newStadium.getName());
		this.stadiumDao.save(stadium);
	}

}
