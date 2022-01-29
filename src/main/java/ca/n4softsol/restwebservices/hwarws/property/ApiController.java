package ca.n4softsol.restwebservices.hwarws.property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	DockerProperties dockerProperties;

	@Autowired
	private DummyRepository dummyRepository;

	@RequestMapping(value = "/api/public/docker", method = RequestMethod.GET)
	public Map<String, String> homeDocker() {
		String dockerContainer = dockerProperties.getDocker().getContainerName();
		String dockerImage = dockerProperties.getDocker().getImageName();
//		System.out.println("===== Values: " + dockerProperties.getDocker().getContainerName());
		HashMap<String, String> map = new HashMap<>();
		logger.info("Rest API Controller Method: homeDocker()-/api/public/docker");

		try {
			map.put("ImageName", dockerImage);
			map.put("ContainerName", dockerContainer);
			logger.info("Rest API Controller Method: homeDocker()- Successfully Processed.");
			return map;
		} catch (Exception e) {
			logger.error("Rest API Controller Method: homeDocker()-Error:Request /api/public/docker NOT accessible.");
			return map;
		}
	}


	@RequestMapping(value = "/api/public/dummy", method = RequestMethod.GET)
	public List<Dummy> homeDummy() {

		logger.info("Rest API Controller Method: homeDummy()-/api/public/dummy");
		try {
			logger.info("Rest API Controller Method: homeDummy()- Successfully Processed.");
			return dummyRepository.findAll();
		} catch (Exception e) {
			logger.error("Rest API Controller Method: homeDummy()-Error:Request /api/public/dummy NOT accessible.");
			return dummyRepository.findAll();
		}

	}
}
