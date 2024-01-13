package tn.iit.matchService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tn.iit.matchService.response.PlayerResponse;

@FeignClient(value = "player-service", url = "localhost:8090", path = "/players")
public interface PlayerFeignClient {
	@GetMapping("/{id}")
	public PlayerResponse getById(@PathVariable long id);

}
