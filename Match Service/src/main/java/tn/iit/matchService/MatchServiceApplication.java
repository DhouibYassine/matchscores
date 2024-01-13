package tn.iit.matchService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tn.iit.matchService.Exeption.CustomErrorDecoder;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("tn.iit.matchService.feign")
public class MatchServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MatchServiceApplication.class, args);
    }

    @Bean
    public CustomErrorDecoder mCustomErrorDecoder() {
        return new CustomErrorDecoder();
    }
}
