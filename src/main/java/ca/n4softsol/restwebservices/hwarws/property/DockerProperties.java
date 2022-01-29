package ca.n4softsol.restwebservices.hwarws.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties
@PropertySource("classpath:docker.properties")
public class DockerProperties {

	@Getter
	@Setter
	Docker docker;

	@Data
	public static class Docker {
		String containerName;
		String imageName;
	}

}
