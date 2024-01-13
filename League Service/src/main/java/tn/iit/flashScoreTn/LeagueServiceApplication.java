package tn.iit.flashScoreTn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("tn.iit.flashScoreTn.feign")
public class LeagueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueServiceApplication.class, args);
	}

}
