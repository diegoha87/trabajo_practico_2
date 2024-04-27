package ar.edu.unju.fi.ejercicio02.main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Efemeride> listaEfemeride = new ArrayList<Efemeride>();
		int opcion = 0;
		String codigo;
		int opcionMes= 0;
		Mes mes = Mes.ENERO;
		int dia = 0;
		String detalle;
		int inicioMes = 0;
		int finMes = 0;
		do {
			boolean repetir2 = true;
			boolean repetir = true;
			boolean repetir3 = true;
			boolean band5 = true;
			boolean repetir4 = true;
			do {
				try {
					System.out.println("**********MENÚ***********");
					System.out.println("1- Agregar efeméride.");
					System.out.println("2- Mostrar efemérides.");
					System.out.println("3- Eliminar efeméride.");
					System.out.println("4- Modificar efeméride.");
					System.out.println("5- Salir.");
					System.out.println("*************************");
					System.out.println("Ingrese una opción: ");
					opcion = scanner.nextInt();	
					repetir = false;
					
				}
				catch(InputMismatchException e) {
					scanner.nextLine();
					System.out.println("----------------------------");
					System.out.println("Ingrese una opción correcta.");
					System.out.println("----------------------------");
				}
			}while(repetir);
			
			switch(opcion) {
			case 1:

				System.out.println("----------Agregar Efeméride----------");
				System.out.println("Ingrese el código de la efemérideo: ");
				codigo = scanner.next();
				do {
					try {
						System.out.println("Ingrese el numero del més de la efeméride (1 al 12): ");
						opcionMes = scanner.nextInt();
						repetir2 = false;
							switch(opcionMes) {
							case 1:
								mes = Mes.ENERO;
								inicioMes = 1;
								finMes = 31;
								break;
							case 2:
								mes = Mes.FEBRERO;
								inicioMes = 1;
								finMes = 28;
								break;
							case 3:
								mes = Mes.MARZO;
								inicioMes = 1;
								finMes = 31;
								break;
							case 4:
								mes = Mes.ABRIL;
								inicioMes = 1;
								finMes = 30;
								break;
							case 5:
								mes = Mes.MAYO;
								inicioMes = 1;
								finMes = 31;
								break;
							case 6:
								mes = Mes.JUNIO;
								inicioMes = 1;
								finMes = 30;
								break;
							case 7:
								mes = Mes.JULIO;
								inicioMes = 1;
								finMes = 31;
								break;
							case 8:
								mes = Mes.AGOSTO;
								inicioMes = 1;
								finMes = 31;
								break;
							case 9:
								mes = Mes.SEPTIEMBRE;
								inicioMes = 1;
								finMes = 30;
								break;
							case 10:
								mes = Mes.OCTUBRE;
								inicioMes = 1;
								finMes = 31;
								break;
							case 11:
								mes = Mes.NOVIEMBRE;
								inicioMes = 1;
								finMes = 30;
								break;
							case 12:
								mes = Mes.DICIEMBRE;
								inicioMes = 1;
								finMes = 31;
								break;
							default:
								repetir2 = true;
								System.out.println("-------------------------------------------------------------");
								System.out.println("Error: Debe ingresar un valor númerico del 1 al 12.");
								System.out.println("-------------------------------------------------------------");
							}
						
					}
					catch(InputMismatchException e1) {
						scanner.nextLine();
						System.out.println("-------------------------------------------------------------");
						System.out.println("Error: Debe ingresar un valor númerico del 1 al 12.");
						System.out.println("-------------------------------------------------------------");
					}
				}while(repetir2);
				do {
					try {
						System.out.println("Ingrese el día de la efeméride ("+inicioMes+" al "+finMes+") : ");
						dia = scanner.nextInt();
						
						if(dia >= inicioMes && dia <= finMes) {
							repetir3 = false;
						}
						else {
							scanner.nextLine();
							System.out.println("----------------------------------------------------------------------------");
							System.out.println("Error: Debe ingresar un número comprendido entre "+inicioMes+" y "+finMes+".");
							System.out.println("----------------------------------------------------------------------------");
						}
					}
					catch(InputMismatchException  e1) {
						scanner.nextLine();
						System.out.println("---------------------------------");
						System.out.println("Error: ingrese un valor númerico.");
						System.out.println("---------------------------------");
					}
				}
				while(repetir3);
				scanner.nextLine();
				System.out.println("Ingrese el detalle de la efeméride: ");
				detalle = scanner.nextLine();
				
				Efemeride efemeride1 = new Efemeride(codigo, mes, dia, detalle);
				listaEfemeride.add(efemeride1);
				System.out.println("-------------------------------------------------------------");
				System.out.println("La efeméride se agrego correctamente.");
				System.out.println("-------------------------------------------------------------");
			
				break;
				//scanner.nextLine();
			case 2:
				if(listaEfemeride.isEmpty()) {
					System.out.println("---------------------------------");
					System.out.println("La lista esta vacia.");
					System.out.println("---------------------------------");
				}
				else {
					for(Efemeride f: listaEfemeride) {
						System.out.println("----------Lista de efemérides----------");
						System.out.println("---------------------------------------");
						System.out.println("Código: "+f.getCodigo());
						System.out.println("Més: "+f.getMes());
						System.out.println("Día: "+f.getDia());
						System.out.println("Detalle: "+f.getDetalle());
						System.out.println("---------------------------------------");
					}
				}
				
				break;
			case 3:
				if (listaEfemeride.isEmpty()) {
					System.out.println("---------------------");
					System.out.println("La lista esta vacia.");
					System.out.println("---------------------");
				}
				else {
					do {
						System.out.println("-------------Eliminar Efeméride-----------");
						System.out.println("Ingrese el código de la efeméride: ");
						codigo = scanner.next();
						boolean band4 = false;
						Iterator iterator = listaEfemeride.iterator();
						while(iterator.hasNext() && band4 == false) {
							Efemeride f = (Efemeride) iterator.next();
							if (f.getCodigo().equals(codigo)) {
								iterator.remove();
								System.out.println("-----------------------------");
								System.out.println("La efeméride ha sido eliminado.");
								System.out.println("-----------------------------");
								band4 = true;
								band5 = false;
							}
						}
						if (band4 == false) {
							System.out.println("------------------------------------------------------");
							System.out.println("Error: Código no  registrado. Ingrese un código válido");
							System.out.println("------------------------------------------------------");
						}
					}
					while(band5);
				}
				break;
			case 4:
				if (listaEfemeride.isEmpty()) {
					System.out.println("---------------------");
					System.out.println("La lista esta vacia.");
					System.out.println("---------------------");
				}
				else {
					boolean band = false;
					do {
						System.out.println("----------Modificar Efeméride----------");
						System.out.println("Ingrese el código de la efemérideo: ");
						codigo = scanner.next();
						for(int i = 0;i < listaEfemeride.size() && band == false; i++) {
							Efemeride elementoLista = listaEfemeride.get(i);
							if(elementoLista.getCodigo().equals(codigo)) {
								band = true;
								do {
									try {
										System.out.println("Ingrese el numero del més de la efeméride (1 al 12): ");
										opcionMes = scanner.nextInt();
										repetir2 = false;
											switch(opcionMes) {
											case 1:
												mes = Mes.ENERO;
												inicioMes = 1;
												finMes = 31;
												break;
											case 2:
												mes = Mes.FEBRERO;
												inicioMes = 1;
												finMes = 28;
												break;
											case 3:
												mes = Mes.MARZO;
												inicioMes = 1;
												finMes = 31;
												break;
											case 4:
												mes = Mes.ABRIL;
												inicioMes = 1;
												finMes = 30;
												break;
											case 5:
												mes = Mes.MAYO;
												inicioMes = 1;
												finMes = 31;
												break;
											case 6:
												mes = Mes.JUNIO;
												inicioMes = 1;
												finMes = 30;
												break;
											case 7:
												mes = Mes.JULIO;
												inicioMes = 1;
												finMes = 31;
												break;
											case 8:
												mes = Mes.AGOSTO;
												inicioMes = 1;
												finMes = 31;
												break;
											case 9:
												mes = Mes.SEPTIEMBRE;
												inicioMes = 1;
												finMes = 30;
												break;
											case 10:
												mes = Mes.OCTUBRE;
												inicioMes = 1;
												finMes = 31;
												break;
											case 11:
												mes = Mes.NOVIEMBRE;
												inicioMes = 1;
												finMes = 30;
												break;
											case 12:
												mes = Mes.DICIEMBRE;
												inicioMes = 1;
												finMes = 31;
												break;
											default:
												repetir2 = true;
												System.out.println("-------------------------------------------------------------");
												System.out.println("Error: Debe ingresar un valor númerico del 1 al 12.");
												System.out.println("-------------------------------------------------------------");
											}
										
									}
									catch(InputMismatchException e) {
										scanner.nextLine();
										System.out.println("-------------------------------------------------------------");
										System.out.println("Error: Debe ingresar un valor númerico del 1 al 12.");
										System.out.println("-------------------------------------------------------------");
									}
								}while(repetir2);
								do {
									try {
										System.out.println("Ingrese el día de la efeméride ("+inicioMes+" al "+finMes+") : ");
										dia = scanner.nextInt();
										
										if(dia >= inicioMes && dia <= finMes) {
											repetir3 = false;
										}
										else {
											scanner.nextLine();
											System.out.println("----------------------------------------------------------------------------");
											System.out.println("Error: Debe ingresar un número comprendido entre "+inicioMes+" y "+finMes+".");
											System.out.println("----------------------------------------------------------------------------");
										}
									}
									catch(InputMismatchException  e) {
										scanner.nextLine();
										System.out.println("---------------------------------");
										System.out.println("Error: ingrese un valor númerico.");
										System.out.println("---------------------------------");
									}
								}
								while(repetir3);
								scanner.nextLine();
								System.out.println("Ingrese el detalle de la efeméride: ");
								detalle = scanner.nextLine();
								
								Efemeride efemeride2 = new Efemeride(codigo, mes, dia, detalle);
								listaEfemeride.set(i, efemeride2);
							}
						}
						if (band == false) {
							System.out.println("------------------------------------------------");
							System.out.println("La efeméride no existe. Ingrese un código válido");
							System.out.println("------------------------------------------------");
						}
						else {
							System.out.println("-------------------------------");
							System.out.println("La efeméride ha sido modificado.");
							System.out.println("-------------------------------");
						}
					}while(band==false);
				}
				break;
			case 5:
				System.out.println("----------------------------");
				System.out.println("FIN DEL PROGRAMA.");
				System.out.println("----------------------------");
				break;
			default:
				System.out.println("----------------------------");
				System.out.println("Ingrese una opción correcta.");
				System.out.println("----------------------------");
			}
		}while(opcion != 5);
	}

}
