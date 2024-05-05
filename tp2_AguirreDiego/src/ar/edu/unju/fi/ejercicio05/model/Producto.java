package ar.edu.unju.fi.ejercicio05.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private double precioUnitario;
	private origenFabricacion origen;
	private Categoria categoria;
	private boolean isDisponible;
	
	public Producto() {
		
	}
	
	
	
	public Producto(String codigo, String descripcion, double precioUnitario, origenFabricacion origen, Categoria categoria, boolean isDisponible) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origen = origen;
		this.categoria = categoria;
		this.isDisponible = isDisponible;
	}



	public boolean isDisponible() {
		return isDisponible;
	}



	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}



	public enum origenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public double getPrecioUnitario() {
		return precioUnitario;
	}



	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}



	public origenFabricacion getOrigen() {
		return origen;
	}



	public void setOrigen(origenFabricacion origen) {
		this.origen = origen;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origen=" + origen + ", categoria=" + categoria + ", isDisponible=" + isDisponible + "]";
	}
	
	
}
