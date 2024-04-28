package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.model.Efemeride;
import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Jugador> listaJugadores = new ArrayList<Jugador>();
		int opcion = 0;
		String nombre;
		String apellido;
		String nacionalidad;
		int anio = 0;
		int mes = 0;
		int dia = 0 ;
		double estatura = 0;
		double peso = 0;
		Posicion posicion = Posicion.ARQUERO;
		int opcionPosicion = 0;
		LocalDate fechaNacimiento = LocalDate.of(1900, 1, 1);
		do {
			boolean repetir= true;
			
			System.out.println("************************MENÚ******************************");
			System.out.println("1- Agregar jugador.");
			System.out.println("2- Mostrar todos los jugadore.");
			System.out.println("3- Modificar la posición de un jugador.");
			System.out.println("4- Eliminar un jugador.");
			System.out.println("5- Salir.");
			System.out.println("**********************************************************");
			System.out.println("Ingrese una opción: ");
			opcion = scanner.nextInt();	
			
			
			switch(opcion) {
			case 1:
				System.out.println("-------Alta de Jugador-----------");
				System.out.println("Ingrese el nombre: ");
				nombre = scanner.next();
				System.out.println("Ingrese el apellido: ");
				apellido = scanner.next();
				System.out.println("Ingrese el nacionalidad: ");
				nacionalidad = scanner.next();
				System.out.println("--Ingrese la fecha de nacimiento--: ");
				do {
					try {
						System.out.println("Ingrese el año: ");
						anio = scanner.nextInt();
						repetir = false;
						}
						catch (Exception e1) {
							scanner.nextLine();
							System.out.println("------------------------------------------------");
							System.out.println("Debe ingresar un valor númerico en el campo año.");
							System.out.println("------------------------------------------------");
						}
				}while(repetir);
				repetir= true;
				do {
					try {
						System.out.println("Ingrese el mes: ");
						mes = scanner.nextInt();
						repetir = false;
					}
					catch (Exception e2) {
						scanner.nextLine();
						System.out.println("------------------------------------------------");
						System.out.println("Debe ingresar un valor númerico en el campo mes.");
						System.out.println("------------------------------------------------");
					}
				}while(repetir);
				
				repetir= true;
				do {
					try {
						System.out.println("Ingrese el dia: ");
						dia = scanner.nextInt();
						fechaNacimiento = LocalDate.of(anio, mes, dia);
						repetir = false;
					}
					catch (Exception e3) {
						scanner.nextLine();
						System.out.println("------------------------------------------------");
						System.out.println("Debe ingresar un valor númerico en el campo dia.");
						System.out.println("------------------------------------------------");
					}
				}while(repetir);
				
				repetir= true;
				do {
					try {
						System.out.println("Ingrese la estatura: ");
						estatura = scanner.nextDouble();
						repetir = false;
					}
					catch (Exception e3) {
						scanner.nextLine();
						System.out.println("-----------------------------------------------------");
						System.out.println("Debe ingresar un valor númerico en el campo estatura.");
						System.out.println("-----------------------------------------------------");
					}
				}while(repetir);
				
				repetir= true;
				do {
					try {
						System.out.println("Ingrese el peso: ");
						peso = scanner.nextDouble();
						repetir = false;
					}
					catch (Exception e3) {
						scanner.nextLine();
						System.out.println("-----------------------------------------------------");
						System.out.println("Debe ingresar un valor númerico en el campo peso.");
						System.out.println("-----------------------------------------------------");
					}
				}while(repetir);
				
				repetir= true;
				do {
					try {
						System.out.println("-----Posición--------: ");
						System.out.println("1- DELANTERO. ");
						System.out.println("2- MEDIO. ");
						System.out.println("3- DEFENSA. ");
						System.out.println("4- ARQUERO. ");
						System.out.println(" ");
						System.out.println("Elija una opción: ");
						opcionPosicion = scanner.nextInt();	
						repetir = false;
						
						switch(opcionPosicion) {
						case 1:
							posicion = Posicion.DELANTERO;
							System.out.println("-----------------------------------------------------");
							System.out.println("El jugador se agrego corectamente.");
							System.out.println("-----------------------------------------------------");
							break;
						case 2:
							posicion = Posicion.MEDIO;
							System.out.println("-----------------------------------------------------");
							System.out.println("El jugador se agrego corectamente.");
							System.out.println("-----------------------------------------------------");
							break;
						case 3:
							posicion = Posicion.DEFENSA;
							System.out.println("-----------------------------------------------------");
							System.out.println("El jugador se agrego corectamente.");
							System.out.println("-----------------------------------------------------");
							break;
						case 4:
							posicion = Posicion.ARQUERO;
							System.out.println("-----------------------------------------------------");
							System.out.println("El jugador se agrego corectamente.");
							System.out.println("-----------------------------------------------------");
							break;
						default:
							repetir= true;
							System.out.println("---------------------------------");
							System.out.println("Error: Ingrese una opción valida.");
							System.out.println("---------------------------------");
						}
						Jugador jugador1 = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
						listaJugadores.add(jugador1);
						
					}
					catch (Exception e4) {
						scanner.nextLine();
						System.out.println("---------------------------------");
						System.out.println("Error: Ingrese una opción valida.");
						System.out.println("---------------------------------");
					}
				}while(repetir);
				break;
			case 2:
				if(listaJugadores.isEmpty()) {
					System.out.println("---------------------------------");
					System.out.println("La lista esta vacia.");
					System.out.println("---------------------------------");
				}
				else {
					System.out.println("----------Lista de jugadores----------");
					for(Jugador j: listaJugadores) {
						
						System.out.println("---------------------------------------");
						System.out.println("Nombre: "+j.getNombre());
						System.out.println("Apellido: "+j.getApellido());
						System.out.println("Fecha de Nacimiento: "+j.getFechaNacimiento());
						System.out.println("Edad: "+j.calcularEdad());
						System.out.println("Estatura: "+j.getEstatura());
						System.out.println("Peso: "+j.getPeso());
						System.out.println("Edad: "+j.getPosicion());
						System.out.println("---------------------------------------");
					}
				}

				break;
			case 3:
				if(listaJugadores.isEmpty()) {
					System.out.println("---------------------------------");
					System.out.println("La lista esta vacia.");
					System.out.println("---------------------------------");
				}
				else {
					System.out.println("-------Modificar Datos del Jugador-----------");
					boolean band3 = true;
					do {
						System.out.println("Ingrese el nombre: ");
						nombre = scanner.next();
						System.out.println("Ingrese el apellido: ");
						apellido = scanner.next();
						
						for (int i = 0;i < listaJugadores.size() && band3 == true;i++) {
							Jugador elementoLista = listaJugadores.get(i);
							if (elementoLista.getNombre().equals(nombre) && elementoLista.getApellido().equals(apellido)) {
								band3 = false;
								System.out.println("Ingrese el nacionalidad: ");
								nacionalidad = scanner.next();
								System.out.println("--Ingrese la fecha de nacimiento--: ");
								do {
									try {
										System.out.println("Ingrese el año: ");
										anio = scanner.nextInt();
										repetir = false;
										}
										catch (Exception e1) {
											scanner.nextLine();
											System.out.println("------------------------------------------------");
											System.out.println("Debe ingresar un valor númerico en el campo año.");
											System.out.println("------------------------------------------------");
										}
								}while(repetir);
								repetir= true;
								do {
									try {
										System.out.println("Ingrese el mes: ");
										mes = scanner.nextInt();
										repetir = false;
									}
									catch (Exception e2) {
										scanner.nextLine();
										System.out.println("------------------------------------------------");
										System.out.println("Debe ingresar un valor númerico en el campo mes.");
										System.out.println("------------------------------------------------");
									}
								}while(repetir);
								
								repetir= true;
								do {
									try {
										System.out.println("Ingrese el dia: ");
										dia = scanner.nextInt();
										fechaNacimiento = LocalDate.of(anio, mes, dia);
										repetir = false;
									}
									catch (Exception e3) {
										scanner.nextLine();
										System.out.println("------------------------------------------------");
										System.out.println("Debe ingresar un valor númerico en el campo dia.");
										System.out.println("------------------------------------------------");
									}
								}while(repetir);
								
								repetir= true;
								do {
									try {
										System.out.println("Ingrese la estatura: ");
										estatura = scanner.nextDouble();
										repetir = false;
									}
									catch (Exception e3) {
										scanner.nextLine();
										System.out.println("-----------------------------------------------------");
										System.out.println("Debe ingresar un valor númerico en el campo estatura.");
										System.out.println("-----------------------------------------------------");
									}
								}while(repetir);
								
								repetir= true;
								do {
									try {
										System.out.println("Ingrese el peso: ");
										peso = scanner.nextDouble();
										repetir = false;
									}
									catch (Exception e3) {
										scanner.nextLine();
										System.out.println("-----------------------------------------------------");
										System.out.println("Debe ingresar un valor númerico en el campo peso.");
										System.out.println("-----------------------------------------------------");
									}
								}while(repetir);
								
								repetir= true;
								do {
									try {
										System.out.println("-----Posición--------: ");
										System.out.println("1- DELANTERO. ");
										System.out.println("2- MEDIO. ");
										System.out.println("3- DEFENSA. ");
										System.out.println("4- ARQUERO. ");
										System.out.println(" ");
										System.out.println("Elija una opción: ");
										opcionPosicion = scanner.nextInt();	
										repetir = false;
										
										switch(opcionPosicion) {
										case 1:
											posicion = Posicion.DELANTERO;
											break;
										case 2:
											posicion = Posicion.MEDIO;
											break;
										case 3:
											posicion = Posicion.DEFENSA;
											break;
										case 4:
											posicion = Posicion.ARQUERO;
											break;
										default:
											repetir= true;
											System.out.println("---------------------------------");
											System.out.println("Error: Ingrese una opción valida.");
											System.out.println("---------------------------------");
										}
										Jugador jugador2 = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
										listaJugadores.set(i, jugador2);
										
									}
									catch (Exception e4) {
										scanner.nextLine();
										System.out.println("---------------------------------");
										System.out.println("Error: Ingrese una opción valida.");
										System.out.println("---------------------------------");
									}
								}while(repetir);
							}
						}
						if (band3 == true) {
							System.out.println("-------------------------------------------------------------------");
							System.out.println("Error: Jugador no  registrado. Ingrese un nombre y apellido válido.");
							System.out.println("-------------------------------------------------------------------");
						}
						else {
							System.out.println("-----------------------------");
							System.out.println("El jugador ha sido modificado.");
							System.out.println("-----------------------------");
						}
					}while(band3);
				}
				break;
			case 4:
				if (listaJugadores.isEmpty()) {
					System.out.println("---------------------");
					System.out.println("La lista esta vacia.");
					System.out.println("---------------------");
				}
				else {
					do {
						System.out.println("-------------Eliminar Jugador-----------");
						System.out.println("Ingrese el nombre: ");
						nombre = scanner.next();
						System.out.println("Ingrese el apellido: ");
						apellido = scanner.next();
						boolean band4 = false;
						Iterator iterator = listaJugadores.iterator();
						while(iterator.hasNext() && band4 == false) {
							Jugador j = (Jugador) iterator.next();
							if (j.getNombre().equals(nombre) && j.getApellido().equals(apellido)) {
								iterator.remove();
								System.out.println("-----------------------------");
								System.out.println("El jugador ha sido eliminado.");
								System.out.println("-----------------------------");
								band4 = true;
								repetir = false;
							}
						}
						if (band4 == false) {
							System.out.println("-------------------------------------------------------------------");
							System.out.println("Error: Jugador no  registrado. Ingrese un nombre y apellido válido.");
							System.out.println("-------------------------------------------------------------------");
						}
					}
					while(repetir);
				}
				break;
			case 5:
				System.out.println("-----------------");
				System.out.println("FIN DEL PROGRAMA.");
				System.out.println("-----------------");
				break;
			default:
				System.out.println("----------------------------");
				System.out.println("Ingrese una opción correcta.");
				System.out.println("----------------------------");
			}
		}while(opcion != 5);
		

	}

}
