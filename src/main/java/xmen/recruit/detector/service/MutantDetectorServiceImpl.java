package xmen.recruit.detector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Carlos Pedroza
 * @version 2.0
 * @date 10-01-2022
 * Servicio encargado de responder si un humano es o no mutante.
 *
 */
@Service
public class MutantDetectorServiceImpl implements MutantDetectorService {
	
	@Autowired
	MutantDetector2 detector;
	
	public Boolean isMutant(String[] dna) {
		Boolean respuesta = Boolean.FALSE;
		
		if(detector.tieneValoresPermitidos(dna) &&
				detector.tieneSecuenciaHorizontal(dna)&&
				detector.tieneSecuenciaVertical(dna)&&
				detector.tieneSecuenciaOblicua(dna))
			respuesta = Boolean.TRUE;
			
			
		return respuesta;
		
	}

}
