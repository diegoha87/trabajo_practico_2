package ar.edu.unju.fi.ejercicio01.main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.origenFabricacion;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Producto> listaProductos = new ArrayList<Producto>();
		int opcion = 0;
		int opcionCategoria = 0;
		int opcionOrigen = 0;
		String codigo;
		String descripcion;
		double precioUnitario = 0;
		origenFabricacion origen = origenFabricacion.ARGENTINA;
		Categoria categoria = Categoria.INFORMATICA;
		
		do {
			boolean repetir1 = true;
			boolean repetir2 = true;
			boolean repetirOrigen = true;
			boolean repetirCategoria = true;
			do {
				try {
					System.out.println("**************MENÚ***************");
					System.out.println("1) Crear producto.");
					System.out.println("2) Mostrar productos.");
					System.out.println("3) Modificar producto.");
					System.out.println("4) Salir.");
					System.out.println(" ");
					System.out.println("Ingrese una opción: ");
					opcion = scanner.nextInt();
					repetir1 = false;
				}
				catch(InputMismatchException e) {
					scanner.nextLine();
					System.out.println("----------------------------");
					System.out.println("Ingrese una opción correcta.");
					System.out.println("----------------------------");
				}
			}while(repetir1);
			
			
			
			switch(opcion) {
			case 1:
				scanner.nextLine();
				System.out.println("----------Agregar Productos----------");
				System.out.println("Ingrese el código del producto: ");
				codigo = scanner.nextLine();
				System.out.println("Ingrese la descripción del producto: ");
				descripcion = scanner.nextLine();
				do {
					try {
						System.out.println("Ingrese el precio del producto: ");
						precioUnitario = scanner.nextDouble();
						repetir2 = false;
					}
					catch(InputMismatchException e) {
						scanner.nextLine();
						System.out.println("--------------------------------------------");
						System.out.println("Error: el precio debe ser un valor númerico.");
						System.out.println("--------------------------------------------");
					}
				}while(repetir2);
				
				do {
					try {
						System.out.println("----Origen de fabricación-----");
						System.out.println("1- Argentina.");
						System.out.println("2- China.");
						System.out.println("3-Brasil.");
						System.out.println("4-Uruguay.");
						System.out.println(" ");
						System.out.println("Elija una opción: ");
						opcionOrigen = scanner.nextInt();
						repetirOrigen = false;
						
						switch(opcionOrigen) {
						case 1:
							origen = origenFabricacion.ARGENTINA;
							break;
						case 2:
							origen = origenFabricacion.CHINA;
							break;
						case 3:
							origen = origenFabricacion.BRASIL;
							break;
						case 4:
							origen = origenFabricacion.URUGUAY;
							break;
						default:
							repetirOrigen = true;
							System.out.println("----------------------------");
							System.out.println("Error: Elija un opción correcta");
							System.out.println("----------------------------");
						}
					}
					catch(InputMismatchException e) {
						scanner.nextLine();
						System.out.println("---------------------------------");
						System.out.println("Error: Elija una opcion correcta.");
						System.out.println("---------------------------------");
					}
				}while(repetirOrigen);
				
				do {
					try {
						System.out.println("----Categoría-----");
						System.out.println("1- Telefonía.");
						System.out.println("2- Informática.");
						System.out.println("3-Electro hogar.");
						System.out.println("4-Herramientas.");
						System.out.println(" ");
						System.out.println("Elija una opción: ");
						opcionCategoria = scanner.nextInt();
						repetirCategoria = false;
						
						switch(opcionCategoria) {
						case 1:
							categoria = Categoria.TELEFONIA;
							break;
						case 2:
							categoria = Categoria.INFORMATICA;
							break;
						case 3:
							categoria = Categoria.ELECTROHOGAR;
							break;
						case 4:
							categoria = Categoria.HERRAMIENTAS;
							break;
						default:
							repetirCategoria = true;
							System.out.println("-------------------------------");
							System.out.println("Error: Elija un opción correcta");
							System.out.println("-------------------------------");
						}
						Producto producto1 = new Producto(codigo, descripcion, precioUnitario, origen, categoria);
						listaProductos.add(producto1);
					}
					catch(InputMismatchException e) {
						scanner.nextLine();
						System.out.println("---------------------------------");
						System.out.println("Error: Elija una opcion correcta.");
						System.out.println("---------------------------------");
					}
				}while(repetirCategoria);
				break;
			case 2:
				if (listaProductos.isEmpty()) {
					System.out.println("---------------------------------");
					System.out.println("La lista esta vacia.");
					System.out.println("---------------------------------");
				}
				else {
					for (Producto p: listaProductos) {
						System.out.println("---------------------------------------");
						System.out.println("Nombre: "+p.getCodigo());
						System.out.println("Descripción: "+p.getDescripcion());
						System.out.println("Origen de fabrica: "+p.getOrigen());
						System.out.println("Categoría: "+p.getCategoria());	
						System.out.println("---------------------------------------");
					}
				}
				break;
			case 3:
				if(listaProductos.isEmpty()) {
					System.out.println("---------------------------------");
					System.out.println("La lista esta vacia.");
					System.out.println("---------------------------------");
				}
				else {
					
				}
				boolean band = false;
				System.out.println("-------Modificar producto--------- ");
				System.out.println("Ingrese el codigo del producto:");
				codigo = scanner.next();
				for(int i= 0; i < listaProductos.size() && band == false; i++) {
					Producto elementoLista = listaProductos.get(i);
					if (elementoLista.getCodigo().equals(codigo)) {
						band = true;
						scanner.nextLine();
						System.out.println("Ingrese la descripción del producto: ");
						descripcion = scanner.nextLine();
						do {
							try {
								System.out.println("Ingrese el precio del producto: ");
								precioUnitario = scanner.nextDouble();
								repetir2 = false;
							}
							catch(InputMismatchException e) {
								scanner.nextLine();
								System.out.println("--------------------------------------------");
								System.out.println("Error: el precio debe ser un valor númerico.");
								System.out.println("--------------------------------------------");
							}
						}while(repetir2);
						
						do {
							try {
								System.out.println("----Origen de fabricación-----");
								System.out.println("1- Argentina.");
								System.out.println("2- China.");
								System.out.println("3-Brasil.");
								System.out.println("4-Uruguay.");
								System.out.println(" ");
								System.out.println("Elija una opción: ");
								opcionOrigen = scanner.nextInt();
								repetirOrigen = false;
								
								switch(opcionOrigen) {
								case 1:
									origen = origenFabricacion.ARGENTINA;
									break;
								case 2:
									origen = origenFabricacion.CHINA;
									break;
								case 3:
									origen = origenFabricacion.BRASIL;
									break;
								case 4:
									origen = origenFabricacion.URUGUAY;
									break;
								default:
									repetirOrigen = true;
									System.out.println("----------------------------");
									System.out.println("Error: Elija un opción correcta");
									System.out.println("----------------------------");
								}
							}
							catch(InputMismatchException e) {
								scanner.nextLine();
								System.out.println("---------------------------------");
								System.out.println("Error: Elija una opcion correcta.");
								System.out.println("---------------------------------");
							}
						}while(repetirOrigen);
						
						do {
							try {
								System.out.println("----Categoría-----");
								System.out.println("1- Telefonía.");
								System.out.println("2- Informática.");
								System.out.println("3-Electro hogar.");
								System.out.println("4-Herramientas.");
								System.out.println(" ");
								System.out.println("Elija una opción: ");
								opcionCategoria = scanner.nextInt();
								repetirCategoria = false;
								
								switch(opcionCategoria) {
								case 1:
									categoria = Categoria.TELEFONIA;
									break;
								case 2:
									categoria = Categoria.INFORMATICA;
									break;
								case 3:
									categoria = Categoria.ELECTROHOGAR;
									break;
								case 4:
									categoria = Categoria.HERRAMIENTAS;
									break;
								default:
									repetirCategoria = true;
									System.out.println("-------------------------------");
									System.out.println("Error: Elija un opción correcta");
									System.out.println("-------------------------------");
								}
								Producto producto2 = new Producto(codigo, descripcion, precioUnitario, origen, categoria);
								listaProductos.set(i, producto2);
							}
							catch(InputMismatchException e) {
								scanner.nextLine();
								System.out.println("---------------------------------");
								System.out.println("Error: Elija una opcion correcta.");
								System.out.println("---------------------------------");
							}
						}while(repetirCategoria);
					}
				}
				
				if (band == false) {
					System.out.println("---------------------------");
					System.out.println("El producto no existe.");
					System.out.println("---------------------------");
				}
				else {
					System.out.println("-----------------------------");
					System.out.println("El producto ha sido modificado.");
					System.out.println("-----------------------------");
				}
				break;
			case 4:
				System.out.println("Fin del programa");
				break;
			default:
				System.out.println("----------------------------");
				System.out.println("Ingrese una opción correcta.");
				System.out.println("----------------------------");
			}
			
		}while(opcion != 4);

	}

}
