package ca.n4softsol.restwebservices.hwarws.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SchemaController {

	private static final Logger logger = LoggerFactory.getLogger(SchemaController.class);

	@Autowired
	private DummyIamrwsRepository dummyIamrwsRepository;

	@Autowired
	private DummyTdorwsRepository dummyTdorwsRepository;

	@Autowired
	private DummyHwarwsRepository dummyHwarwsRepository;

	private List<?> responserws;

	@RequestMapping(value = "/api/public/dummy/{schema}", method = RequestMethod.GET)

	public ResponseEntity<List<?>> selectSchema(@PathVariable String schema) {

		String iamrws = "iamrws";
		String tdorws = "tdorws";
		String hwarws = "hwarws";

		if (schema.equals(iamrws)) {
			logger.info("Rest API Controller Method: selectSchema()-/api/public/" + schema);
			System.out.println("Selected Schema: " + schema);

			try {
				List<DummyIamrws> responseIamrws = dummyIamrwsRepository.findAll();
				responserws = responseIamrws;
				logger.info("Rest API Controller Method: selectSchema()- Successfully Processed.");
			} catch (Exception e) {
				logger.error(
						"Rest API Controller Method: selectSchema()-Error:Request /api/public/${schema} NOT accessible.");
			}
			return new ResponseEntity<List<?>>(responserws, HttpStatus.OK);

		} else if (schema.equals(tdorws)) {
			logger.info("Rest API Controller Method: selectSchema()-/api/public/" + schema);
			System.out.println("Selected Schema: " + schema);

			try {
				List<?> responseTdorws = dummyTdorwsRepository.findAll();
				responserws = responseTdorws;
				logger.info("Rest API Controller Method: selectSchema()- Successfully Processed.");
			} catch (Exception e) {
				logger.error(
						"Rest API Controller Method: selectSchema()-Error:Request /api/public/${schema} NOT accessible.");
			}
			return new ResponseEntity<List<?>>(responserws, HttpStatus.OK);

		} else if (schema.equals(hwarws)) {
			logger.info("Rest API Controller Method: selectSchema()-/api/public/" + schema);
			System.out.println("Selected Schema: " + schema);

			try {
				List<?> responseHwarws = dummyHwarwsRepository.findAll();
				responserws = responseHwarws;
				logger.info("Rest API Controller Method: selectSchema()- Successfully Processed.");
			} catch (Exception e) {
				logger.error(
						"Rest API Controller Method: selectSchema()-Error:Request /api/public/${schema} NOT accessible.");
			}
			return new ResponseEntity<List<?>>(responserws, HttpStatus.OK);
		} else {
			logger.info("Rest API Controller Method: selectSchema()-/api/public/" + schema);
			System.out.println("Selected Schema: " + schema);
		}

		return null;

	}

}
