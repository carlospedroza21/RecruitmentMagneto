package xmen.recruit.detector.ws.vo;

/**
 * 
 * @author Carlos Pedroza
 * @version 1.0
 * @date 27-12-2021
 * Encargado de transportar el request del servicio /mutant.
 *
 */
public class DnaRequest {


	public String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

}
