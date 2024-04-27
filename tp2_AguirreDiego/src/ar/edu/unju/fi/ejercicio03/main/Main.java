package ar.edu.unju.fi.ejercicio03.main;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		//List<Provincia> listaProvincia = new ArrayList<Provincia>();
		Provincia [] listaProvincia = Provincia.values();
		System.out.println("********************PROVINCIAS************************");
		for(Provincia p: listaProvincia) {
			System.out.println("-------------------"+p.name()+"-----------------");
			System.out.println("------------------------------------------------");
			System.out.println("Cantidad de Población: "+p.getCantidadPoblacion());
			System.out.println("Superficie: "+p.getSuperficie());
			System.out.println("Densidad: "+p.calcularDensidadPoblacional());
			System.out.println("------------------------------------------------");
		}

	}

}
