package edu.unlz.taller.programacion.tp.individual;

import edu.unlz.taller.programacion.tp.individual.constantes.Constantes;

public class InmuebleTechado extends Inmueble {
//ATRIBUTOS
	private Integer cantidadDeAmbientes;
	private Boolean tieneCochera;
	private Boolean tienePiscina;

// CONSTRUCTOR
	/**
	 * @param domicilio
	 * @param superficie
	 * @param precio
	 * @param reservado
	 * @param vendido
	 * @param propietario
	 * @param cantidadDeAmbientes
	 * @param tieneCochera
	 * @param tienePiscina
	 */

	public InmuebleTechado(String domicilio, Integer superficie, Double precio, Boolean reservado, Boolean vendido,
			Cliente propietario, Integer cantidadDeAmbientes, Boolean tieneCochera, Boolean tienePiscina) {
		super(domicilio, superficie, precio, reservado, vendido, propietario);
		this.cantidadDeAmbientes = cantidadDeAmbientes;
		this.tieneCochera = tieneCochera;
		this.tienePiscina = tienePiscina;
	}

//METODOS
	@Override
	public void imprimirDatos() {
		System.out.println("CANTIDAD DE AMBIENTES: " + this.getCantidadDeAmbientes());
		System.out.println("TIENE COCHERA: " + this.getTieneCochera());
		System.out.println("TIENE PISCINA: " + this.getTienePiscina());
		super.imprimirDatos();

	}

	// este metodo sirve para calcular el beneficio obtenido de los inmuebles
	// vendidos o reservados
	public Double beneficioObtenido(Double COMISION) {
		if (this.tienePiscina == true && this.tieneCochera == false) {
			return super.beneficioObtenido(COMISION + Constantes.COMISION_CON_PISCINA);
		} else if (this.tieneCochera == true) {
			return super.beneficioObtenido(COMISION + Constantes.COMISION_CON_COCHERA);
		} else {
			return super.beneficioObtenido(COMISION);
		}
	}

	// este metodo sirve para calcular el beneficio obtenido de los inmuebles ni
	// vendidos ni reservados (es el mismo metodo,
	// pero los separo por si en un futuro se quiere modificar solo uno

	public Double beneficioEsperado(Double COMISION) {
		if (this.tienePiscina == true && this.tieneCochera == false) {
			return super.beneficioEsperado(COMISION + Constantes.COMISION_CON_PISCINA);
		} else if (this.tieneCochera == true) {
			return super.beneficioEsperado(COMISION + Constantes.COMISION_CON_COCHERA);
		} else {
			return super.beneficioEsperado(COMISION);
		}
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

	public Integer getCantidadDeAmbientes() {
		return cantidadDeAmbientes;
	}

	public void setCantidadDeAmbientes(Integer cantidadDeAmbientes) {
		this.cantidadDeAmbientes = cantidadDeAmbientes;

	}

	public Boolean getTieneCochera() {
		return tieneCochera;
	}

	public void setTieneCochera(Boolean tieneCochera) {
		this.tieneCochera = tieneCochera;
	}

	public Boolean getTienePiscina() {
		return tienePiscina;
	}

	public void setTienePiscina(Boolean tienePiscina) {
		this.tienePiscina = tienePiscina;
	}

}
