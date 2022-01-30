package ca.n4softsol.restwebservices.hwarws.property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HelloWorldController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {

		String greet = "Hello World";
		logger.info("Rest API Controller Method: hello()-/hello");

		try {
			logger.info("Rest API Controller Method: HelloWorldController()- Successfully Processed.");
			return greet;
		} catch (Exception e) {
			logger.error("Rest API Controller Method: HelloWorldController()-Error:Request /hello NOT accessible.");
			return greet;
		}

	}

}
