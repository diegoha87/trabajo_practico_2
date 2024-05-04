package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);
	
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso()); 
		
		FelinoSalvaje felino1 = converter.convert(gato);
		
		converter.mostrarObjeto(felino1);
		
		FelinoSalvaje gato2 = new FelinoSalvaje("Tanner", (byte) 20, 186f);
	    
		boolean nulo = Converter.isNotNull(gato2);
		
		if (nulo){
			Converter<FelinoSalvaje, FelinoDomestico> converter2 = j -> new FelinoDomestico(j.getNombre(), j.getEdad(), j.getPeso());
			
			FelinoDomestico felino2 = converter2.convert(gato2);
			
			converter2.mostrarObjeto(felino2);
		}
		else {
			System.out.println("Objeto Nulo...");
		}
		
		
	}

}
