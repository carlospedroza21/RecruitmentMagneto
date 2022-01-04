package xmen.recruit.detector.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import xmen.recruit.detector.service.MutantDetectorService;
import xmen.recruit.detector.ws.vo.DnaRequest;

/**
 * 
 * @author Carlos Pedroza
 * @version 1.0
 * @date 27-12-2021
 * Controlador Rest encargado de responder si un humano es o no mutante.
 *
 */
@RestController
public class MutantDetectorController {
	
	@Autowired
	private MutantDetectorService service;

	@PostMapping(value = "/mutant", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> mutantDetector(@RequestBody DnaRequest newDna) {
		
		if(service.isMutant(newDna.getDna())) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
}
