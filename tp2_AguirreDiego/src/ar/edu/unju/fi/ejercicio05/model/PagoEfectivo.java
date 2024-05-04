package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago{
	private  double montoPagado;
	private LocalDate fechaPago;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	@Override
	public void realizarPagos(double monto) {
		this.montoPagado = this.montoPagado - monto * 0.10;
		
	}
	
	public void imprimirRecibo() {
		System.out.println("_____________Recibo_______________");
		System.out.println("Fecha de Pago: "+this.fechaPago);
		System.out.println("Monto Pagado: "+this.montoPagado);
		System.out.println("__________________________________");
	}
}
