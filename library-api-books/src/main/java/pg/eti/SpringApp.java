package pg.eti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringApp {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }
}
