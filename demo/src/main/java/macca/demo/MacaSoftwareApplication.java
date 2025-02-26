package macca.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "macca.demo.repositories")
public class MacaSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacaSoftwareApplication.class, args);
	}

}
