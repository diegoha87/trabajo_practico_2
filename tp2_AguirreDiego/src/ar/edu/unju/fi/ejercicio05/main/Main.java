package ar.edu.unju.fi.ejercicio05.main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Producto.origenFabricacion;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Producto> listaProductos = new ArrayList<Producto>();
		cargarProductos(listaProductos);
		double precioProducto = 0;
		int opcion = 0;
		String resp;
		
		do {
			System.out.println("*************MENÚ***************");
			System.out.println("1- Mostrar productos.");
			System.out.println("2- Realizar compra.");
			System.out.println("3- Salir.");
			System.out.println(" ");
			System.out.println("Ingrese una opción: ");
			opcion = scanner.nextInt();
					
			switch(opcion) {
			case 1:
				mostrarProductos(listaProductos);
				break;
			case 2:
				double montoAcum = 0;
				mostrarProductosDisponibles(listaProductos);
				do {
					precioProducto = comprarProductos(listaProductos);
					montoAcum = montoAcum + precioProducto;
					System.out.println("Desea comprar comprar otro producto (s/n):");
					resp = scanner.next();
				}while(!resp.equals("n"));
				
				formasdePago(montoAcum);
				break;
			case 3:
				System.out.println("-----------------");
				System.out.println("FIN DEL PROGRAMA.");
				System.out.println("-----------------");
				break;
			default:
				System.out.println("Error: Ingrese una opcion correcta");
			}
		}while(opcion != 3);

	}
private static void cargarProductos(List<Producto> productos){
	Producto p1 = new Producto ("p01", "MotorolaG41", 200.0, origenFabricacion.CHINA, Categoria.TELEFONIA, true);
	Producto p2 = new Producto ("p02", "Notebook Lenovo", 600, origenFabricacion.URUGUAY, Categoria.INFORMATICA, true);
	Producto p3 = new Producto ("p03", "Microondas", 500.0, origenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
	Producto p4 = new Producto ("p04", "Kit Destornilladores", 150.0, origenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
	Producto p5 = new Producto ("p05", "SamsungA03", 300.0, origenFabricacion.CHINA, Categoria.TELEFONIA, true);
	Producto p6 = new Producto ("p06", "Multimetro", 100.0, origenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, false);
	Producto p7 = new Producto ("p07", "Monitor Philips HD", 350.0, origenFabricacion.ARGENTINA, Categoria.INFORMATICA, false);
	Producto p8 = new Producto ("p08", "Smart TV Android", 450.0, origenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true);
	Producto p9 = new Producto ("p09", "Xiaomi Redmi 9a", 160.0, origenFabricacion.CHINA, Categoria.TELEFONIA, false);
	Producto p10 = new Producto ("p10", "Lavarropa", 230.0, origenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, false);
	Producto p11 = new Producto ("p11", "Placa de video Nvidia", 700.0, origenFabricacion.BRASIL, Categoria.INFORMATICA, true);
	Producto p12 = new Producto ("p12", "Pinza Crimpeadora", 90.0, origenFabricacion.CHINA, Categoria.HERRAMIENTAS, true);
	Producto p13 = new Producto ("p13", "Cable RJ45", 40.0, origenFabricacion.URUGUAY, Categoria.INFORMATICA, true);
	Producto p14 = new Producto ("p14", "Disco SSD 1GB", 120.0, origenFabricacion.BRASIL, Categoria.INFORMATICA, true);
	Producto p15 = new Producto ("p15", "Heladera", 250.0, origenFabricacion.CHINA, Categoria.ELECTROHOGAR, true);
	
	productos.add(p1);
	productos.add(p2);
	productos.add(p3);
	productos.add(p4);
	productos.add(p5);
	productos.add(p6);
	productos.add(p7);
	productos.add(p8);
	productos.add(p9);
	productos.add(p10);
	productos.add(p11);
	productos.add(p12);
	productos.add(p13);
	productos.add(p14);
	productos.add(p15);
	
}

private static void mostrarProductos(List<Producto> productos) {
	System.out.println("----------LISTA DE PRODUCTOS----------");
	for(Producto p: productos) {
		System.out.println("---------------------------------------");
		System.out.println("Nombre: "+p.getCodigo());
		System.out.println("Descripción: "+p.getDescripcion());
		System.out.println("Precio unitario: "+p.getPrecioUnitario());
		System.out.println("Origen de fabrica: "+p.getOrigen());
		System.out.println("Categoría: "+p.getCategoria());	
		if(p.isDisponible()==true) {
			System.out.println("Stock Disponible");
		}
		else {
			System.out.println("Stock no Disponible");
		}
		System.out.println("---------------------------------------");
	}
}

private static void mostrarProductosDisponibles(List<Producto> productos) {
	System.out.println("----------PRODUCTOS DISPONIBLES----------");
	for(Producto p: productos) {
		if (p.isDisponible()) {
			System.out.println("---------------------------------------");
			System.out.println("Nombre: "+p.getCodigo());
			System.out.println("Descripción: "+p.getDescripcion());
			System.out.println("Precio unitario: "+p.getPrecioUnitario());
			System.out.println("Origen de fabrica: "+p.getOrigen());
			System.out.println("Categoría: "+p.getCategoria());
			System.out.println("---------------------------------------");
		}	
	}
}

private static double comprarProductos(List<Producto> productos) {
	Scanner scanner = new Scanner(System.in);
	String codigo;
	double precio = 0;
	boolean encontrado = false;
	do {
		System.out.println(" ");
		System.out.println("-----------------COMPRAR PRODUCTO---------------------");
		System.out.println("Ingrese el código del producto ha comprar: ");
		codigo = scanner.next();
		
		for(Producto p: productos) {
			if(p.getCodigo().equals(codigo) && p.isDisponible()) {
				precio =  p.getPrecioUnitario();
				encontrado = true;
			}
		}
		if (encontrado == false) {
			System.out.println("----------------------------------------------------------");
			System.out.println("Error: Producto no encontrado. Ingrese un código correcto.");
			System.out.println("----------------------------------------------------------");
		}
	}while(encontrado != true);
	
	return precio;
}

private static void formasdePago(double montoAcum) {
	Scanner scanner = new Scanner(System.in);
	int opcion = 0; 
	String numTarjeta;
	LocalDate fechaHoy = LocalDate.now();
	PagoEfectivo efectivo = new PagoEfectivo(montoAcum, fechaHoy);
	PagoTarjeta tarjeta = new PagoTarjeta("455555", fechaHoy, montoAcum);
	boolean repetir = true;
	do {
		try {
			System.out.println("-------FORMAS DE PAGO----------");
			System.out.println("1- Pago efectivo.");
			System.out.println("2- Pago con tarjeta.");
			System.out.println(" ");
			System.out.println("Elija una opción: ");
			opcion = scanner.nextInt();
			repetir = false;
			
			switch(opcion) {
			case 1:
				System.out.println("-------Pago Efectivo----------");
				efectivo.setFechaPago(fechaHoy);
				efectivo.realizarPagos(montoAcum);
				efectivo.imprimirRecibo();
				break;
			case 2:
				System.out.println("-------Pago con Tarjeta----------");
				System.out.println("Ingrese el número de la tarjeta: ");
				numTarjeta = scanner.next();
				tarjeta.setNumeroTarjeta(numTarjeta);
				tarjeta.setFechaPago(fechaHoy);
				tarjeta.realizarPagos(montoAcum);;
				tarjeta.imprimirRecibo();
				break;
			default:
				repetir = true;
				System.out.println("-----------------------------------");
				System.out.println("Error: Ingrese una opción correcta.");
				System.out.println("-----------------------------------");
			}
		}
		catch(InputMismatchException e) {
			scanner.nextLine();
			System.out.println("-----------------------------------");
			System.out.println("Error: Ingrese una opción correcta.");
			System.out.println("-----------------------------------");
		}
		
	}while(repetir);
		
}

}
