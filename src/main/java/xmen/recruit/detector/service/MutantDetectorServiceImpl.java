package xmen.recruit.detector.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import xmen.recruit.detector.constant.Constants;

/**
 * 
 * @author Carlos Pedroza
 * @version 1.0
 * @date 27-12-2021
 * Servicio encargado de responder si un humano es o no mutante.
 *
 */
@Service
public class MutantDetectorServiceImpl implements MutantDetectorService {
	
	public Boolean isMutant(String[] dna) {
		Object[] newDna = {dna};
		Object[] compareDna = {Constants.DNA_MUTANT};
		
		if(Arrays.deepEquals(newDna, compareDna)) {
			return true;
		} else {
			return false;
		}
		
	}

}
