package tn.iit.flashScoreTn.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.iit.flashScoreTn.response.MatchResponse;

import java.util.List;

@FeignClient(value = "match-service", url = "localhost:8091", path = "/match")
public interface MatchFeignClient {

    @GetMapping("/matchday/{id}")
    public List<MatchResponse> getAll(@PathVariable Long id);


}
