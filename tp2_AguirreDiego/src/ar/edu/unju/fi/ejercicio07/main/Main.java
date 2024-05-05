package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Producto.origenFabricacion;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		List<Producto> listaProductos = new ArrayList<Producto>();
		cargarProductos(listaProductos);
		int opcion = 0;
		
		do {
			try {
				System.out.println("*************MENÚ*****************");
				System.out.println("1- Mostrar productos disponibles.");
				System.out.println("2- Mostrar productos sin stock.");
				System.out.println("3- Incrementar los precios de los productos un 20%.");
				System.out.println("4- Mostrar productos de la categoria Electrohogar disponibles");
				System.out.println("5- Ordenar productos por precio de forma descedente.");
				System.out.println("6- Mostrar los productos con los nombres en mayúscula.");
				System.out.println("7- Salir.");
				System.out.println(" ");
				System.out.println("Elija una opción del menú:");
				opcion = scanner.nextInt();
				
				switch(opcion) {
				case 1:
					mostrarDisponibles(listaProductos);
					break;
				case 2: 
					System.out.println("----------PRODUCTOS SIN STOCK----------");
					List<Producto> listaFaltantes = new ArrayList<Producto>();
					 listaFaltantes =  mostrarFaltantes(listaProductos);
					 mostrarProductos(listaFaltantes);
					break;
				case 3:
					System.out.println("----------PRODUCTOS INCREMENTADOS----------");
					List<Producto> productosIncrementados = new ArrayList<Producto>();
					productosIncrementados =  aumentarPrecio(listaProductos);
					 mostrarProductos(productosIncrementados);
					break;
				case 4:
					System.out.println("----------PRODUCTOS ELECTROHOGAR DISPONIBLES----------");
					List<Producto> productosElectrohogar = new ArrayList<Producto>();
					productosElectrohogar =  mostrarElectrohogar(listaProductos);
					 mostrarProductos(productosElectrohogar);
					break;
				case 5:
					System.out.println("----------PRODUCTOS ORDENADOS POR PRECIOS (DESCENDENTE)----------");
					List<Producto> productosOdenados = new ArrayList<Producto>();
					productosOdenados =  ordenarPorPrecio(listaProductos);
					 mostrarProductos(productosOdenados);
					break;
				case 6:
					System.out.println("----------NOMBRES DE PRODUCTOS EN MAYUSCULAS----------");
					List<Producto> productosNombresMayus = new ArrayList<Producto>();
					productosNombresMayus =  nombresMayusculas(listaProductos);
					 mostrarProductos(productosNombresMayus);
					break;
				case 7:
					System.out.println("-----------------");
					System.out.println("FIN DEL PROGRAMA.");
					System.out.println("-----------------");
					break;
				default:
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
			
			
		}while(opcion != 7);

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
	
	private static List<Producto> mostrarFaltantes(List<Producto> productos) {
		//Predicate y Filter
        Predicate<Producto> condicion = p -> !p.isDisponible(); 
		return productos.stream().filter(condicion).collect(Collectors.toList());
		
    }
	private static void mostrarProductos(List<Producto> productos) {
		for (Producto p: productos) {
			System.out.println("---------------------------------------");
			System.out.println("Nombre: "+p.getCodigo());
			System.out.println("Descripción: "+p.getDescripcion());
			System.out.println("Precio unitario: "+p.getPrecioUnitario());
			System.out.println("Origen de fabrica: "+p.getOrigen());
			System.out.println("Categoría: "+p.getCategoria());
			System.out.println("---------------------------------------");
		}
	}
	private static void mostrarDisponibles(List<Producto> productos) {
		System.out.println("----------PRODUCTOS DISPONIBLES----------");
		Consumer<Producto> mostrar = p -> {if(p.isDisponible()) {
				System.out.println("---------------------------------------");
				System.out.println("Nombre: "+p.getCodigo());
				System.out.println("Descripción: "+p.getDescripcion());
				System.out.println("Precio unitario: "+p.getPrecioUnitario());
				System.out.println("Origen de fabrica: "+p.getOrigen());
				System.out.println("Categoría: "+p.getCategoria());
				System.out.println("---------------------------------------");
			}
		};
		productos.forEach(mostrar);
	}
	
	private static List<Producto> aumentarPrecio(List<Producto> productos) {		
		Function<Producto,Producto> nuevoPrecio = p -> {
			p.setPrecioUnitario(p.getPrecioUnitario()*1.20f);
			return p;
			};
		        
        return productos.stream()
        		.map(nuevoPrecio)
        		.collect(Collectors.toList());
    }
	
	private static List<Producto> mostrarElectrohogar(List<Producto> productos){
		Categoria electroHogar = Categoria.ELECTROHOGAR;
		Predicate<Producto> condicion = p -> p.getCategoria().equals(electroHogar) && p.isDisponible(); 
		return productos.stream().filter(condicion).collect(Collectors.toList());
	}
	
	private static List<Producto> ordenarPorPrecio(List<Producto> productos) {		
		Comparator<Producto> c = Comparator.comparing(Producto :: getPrecioUnitario).reversed();
		        
		productos.sort(c);
		
		return productos;
    }
	
	private static List<Producto> nombresMayusculas(List<Producto> productos) {		
		Function<Producto,Producto> nuevoNombre = n -> {
			n.setDescripcion(n.getDescripcion().toUpperCase());
			return n;
			};
		        
        return productos.stream()
        		.map(nuevoNombre)
        		.collect(Collectors.toList());
    }
	
}
