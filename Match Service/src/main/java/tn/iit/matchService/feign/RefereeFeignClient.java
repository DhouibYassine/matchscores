package tn.iit.matchService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tn.iit.matchService.response.RefereeResponse;

@FeignClient(value = "referee-service", url = "localhost:8090", path = "/refrees")
public interface RefereeFeignClient {
	@GetMapping("/{id}")
	public RefereeResponse getById(@PathVariable long id);

}
