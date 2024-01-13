package tn.iit.matchService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.matchService.Exeption.SubstitutionNotFoundException;
import tn.iit.matchService.feign.PlayerFeignClient;
import tn.iit.matchService.model.Substitution;
import tn.iit.matchService.repository.SubstitutionDao;
import tn.iit.matchService.response.PlayerResponse;
import tn.iit.matchService.response.SubstitutionResponse;

@Service
public class SubstitutionService {

	@Autowired
	SubstitutionDao substitutionDao;

	@Autowired
	PlayerFeignClient playerFeignClient;

	public List<SubstitutionResponse> findAll() {
		List<Substitution> substitutions = this.substitutionDao.findAll();
		List<SubstitutionResponse> substitutionResponses = new ArrayList<>();
		for (Substitution substitution : substitutions) {
			PlayerResponse playerIn = this.playerFeignClient.getById(substitution.getPlayerIn());
			PlayerResponse playerOut = this.playerFeignClient.getById(substitution.getPlayerOut());
			substitutionResponses.add(new SubstitutionResponse(substitution, playerIn, playerOut));
		}
		return substitutionResponses;
	}

	public SubstitutionResponse findById(long id) {
		Substitution substitution = this.substitutionDao.findById(id)
				.orElseThrow(() -> new SubstitutionNotFoundException(id));
		PlayerResponse playerIn = this.playerFeignClient.getById(substitution.getPlayerIn());
		PlayerResponse playerOut = this.playerFeignClient.getById(substitution.getPlayerOut());
		return new SubstitutionResponse(substitution, playerIn, playerOut);
	}

	public void delete(long id) {
		this.substitutionDao.deleteById(id);

	}

	public void save(Substitution goal) {
		this.substitutionDao.save(goal);

	}

	public void update(Substitution newSubstitution, long id) {
		Substitution substitution = this.substitutionDao.findById(id)
				.orElseThrow(() -> new SubstitutionNotFoundException(id));
		substitution.setMinute(newSubstitution.getMinute());
		substitution.setPlayerIn(newSubstitution.getPlayerIn());
		substitution.setPlayerOut(newSubstitution.getPlayerOut());
		this.substitutionDao.save(substitution);
	}

}
