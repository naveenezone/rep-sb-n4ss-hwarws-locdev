package ca.n4softsol.restwebservices.hwarws.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdRunner implements CommandLineRunner {

	@Autowired
	DockerProperties dockerProperties;

	@Value("${hwarws.greet}")
	private String greet;

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("===== Docker: " + dockerProperties.getDocker().getContainerName());
		System.out.println("===== Database: " + dbUrl);
		System.out.println("===== Greet: " + greet);

	}

}
