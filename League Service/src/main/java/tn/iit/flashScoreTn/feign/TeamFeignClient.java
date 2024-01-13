package tn.iit.flashScoreTn.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.iit.flashScoreTn.response.TeamResponse;

@FeignClient(value = "team-service", url = "localhost:8090", path = "/teams")
public interface TeamFeignClient {

    @GetMapping("/{id}")
    public TeamResponse getById(@PathVariable long id);
}
