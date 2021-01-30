package edu.unlz.taller.programacion.tp.individual;

import edu.unlz.taller.programacion.tp.individual.constantes.Imprimible;

public class Inmueble implements Imprimible, Comparable<Inmueble> {
//ATRIBUTOS
	protected String domicilio;
	protected Integer superficie;
	protected Double precio;
	protected Boolean reservado;
	protected Boolean vendido;
	protected Cliente propietario;

// CONSTRUCTOR
	/**
	 * @param domicilio
	 * @param superficie
	 * @param precio
	 * @param reservado
	 * @param vendido
	 * @param propietario
	 */
	public Inmueble(String domicilio, Integer superficie, Double precio, Boolean reservado, Boolean vendido,
			Cliente propietario) {
		this.domicilio = domicilio;
		this.superficie = superficie;
		this.precio = precio;
		this.reservado = reservado;
		this.vendido = vendido;
		this.propietario = propietario;
	}

// METODOS

	public void imprimirDatos() {

		System.out.println("DOMICILIO: " + this.getDomicilio());
		System.out.println("SUPERFICIE: " + this.getSuperficie() + " metros cuadrados");
		System.out.println("PRECIO: $" + this.getPrecio());
		System.out.println("RESERVADO: " + this.getReservado());
		System.out.println("VENDIDO: " + this.getVendido());
		System.out.println(" ");
		this.getPropietario().imprimirDatos();

	}

	// metodo para comparar precios
	@Override
	public int compareTo(Inmueble o) {
		return this.precio.compareTo(o.getPrecio());
	}

	// este metodo sirve para calcular el beneficio obtenido de los inmuebles
	// vendidos o reservados
	public Double beneficioObtenido(Double COMISION) {
		return this.precio * COMISION;
	}

	// este metodo sirve para calcular el beneficio obtenido de los inmuebles ni
	// vendidos ni reservados (es el mismo metodo,
	// pero los separo por si en un futuro se quiere modificar solo uno

	public Double beneficioEsperado(Double COMISION) {
		return this.precio * COMISION;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inmueble other = (Inmueble) obj;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	// GETTERS && SETTERS
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;

	}

	public Integer getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;

	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;

	}

	public Boolean getReservado() {
		return reservado;
	}

	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

	public Cliente getPropietario() {
		return propietario;
	}

	public void setPropietario(Cliente propietario) {
		this.propietario = propietario;

	}

}
