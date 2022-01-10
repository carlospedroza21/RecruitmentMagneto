package xmen.recruit.detector.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import xmen.recruit.detector.constant.Constants;

/**
 * 
 * @author Carlos Pedroza
 * @version 2.0
 * @date 20-01-2022
 * Clase que realiza la deteccion del mutante.
 *  
 */
@Component
public class MutantDetector2 {
	
	/**
	 * Diagonal
	 */
	public Boolean tieneSecuenciaOblicua( String[] newDna ) {
		
		String [][] dna = new String[newDna[0].length()][newDna.length];
		
		for (int i = 0; i < newDna.length; i++) {
			for (int j = 0; j < newDna[i].length(); j++) {
				dna[j][i] = String.valueOf( newDna[i].charAt(j) );
			}
			
		}
		
		Boolean respuesta = Boolean.FALSE;
		
		Integer altura = dna.length;
		Integer anchura = dna[0].length;
		
		for(int diagonal = 1 - anchura; diagonal <= altura - 1; diagonal += 1) {
			String valores = "";
			for(int vertical = Math.max(0, diagonal), horizontal = -Math.min(0, diagonal);
					vertical < altura && horizontal < anchura;
					vertical += 1, horizontal += 1) {
						valores = valores.concat(dna[vertical][horizontal]);
					}
			
			if(!valores.isEmpty()) {
				if( tieneSecuenciaHorizontal( new String[] {valores} ) ) {
					respuesta = Boolean.TRUE;
				}
			}
			
			if(respuesta) 
				break;
		}
		
		return respuesta;
	}
	
	/**
	 * Izquierda hacia derecho
	 */
	public Boolean tieneSecuenciaHorizontal( String[] newDna ) {
		
		Boolean respuesta = Boolean.FALSE;
		for(int j = 0; j < Constants.DNA_EQUAL_SEQ.length; j++) {
			for (int i = 0; i < newDna.length; i++) {
				if(newDna[i].contains(Constants.DNA_EQUAL_SEQ[j]))
					respuesta = Boolean.TRUE;
				
				if(respuesta) 
					break;
			}
			if(respuesta) 
				break;
		}
		
		return respuesta;
	}

	/**
	 * Arriba hacia abajo
	 */
	public Boolean tieneSecuenciaVertical( String[] newDna ) {
		String [][] dna = new String[newDna[0].length()][newDna.length];
		
		for (int i = 0; i < newDna.length; i++) {
			for (int j = 0; j < newDna[i].length(); j++) {
				dna[j][i] = String.valueOf( newDna[i].charAt(j) );
			}
			
		}
		
		Boolean respuesta = Boolean.FALSE;
		
		Integer altura = dna.length;
		Integer anchura = dna[0].length;
		
		for(int alto =0; alto < altura; alto++) {
			String valores = "";
			for(int ancho =0; ancho < anchura; ancho++) {
				valores = valores.concat(dna[alto][ancho]);
			}
			if(!valores.isEmpty()) {
				if( tieneSecuenciaHorizontal( new String[] {valores} ) ) {
					respuesta = Boolean.TRUE;
				}
			}
			
			if(respuesta) 
				break;
		}
		
		return respuesta;
	}
	
	/**
	 * Busca solo los valores permitidos: (A,T,C,G)
	 */
	public Boolean tieneValoresPermitidos( String[] newDna ) {
		
		Boolean respuesta = Boolean.TRUE;
		final Pattern pattern = Pattern.compile("(A|T|C|G)", Pattern.CASE_INSENSITIVE);
		
		for (int i = 0; i < newDna.length; i++) {
			final char[] dnaArreglo = newDna[i].toCharArray();
			for (int j = 0; j < dnaArreglo.length; j++) {
				final Matcher matcher = pattern.matcher(String.valueOf( dnaArreglo[j] ));
				respuesta = matcher.matches();
				
				if(!respuesta) 
					break;
			}
			
			if(!respuesta) 
				break;

		}
		
		return respuesta;
	}
}