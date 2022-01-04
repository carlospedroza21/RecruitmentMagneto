package xmen.recruit.detector.service;

/**
 * 
 * @author Carlos Pedroza
 * @version 1.0
 * @date 27-12-2021
 * Interfaz de servicio encargado de responder si un humano es o no mutante.
 *
 */
public interface MutantDetectorService {

	public Boolean isMutant(String[] dna);

}
