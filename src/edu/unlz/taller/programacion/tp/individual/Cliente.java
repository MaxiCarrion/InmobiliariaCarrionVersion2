package edu.unlz.taller.programacion.tp.individual;

import edu.unlz.taller.programacion.tp.individual.constantes.Imprimible;

//ATRIBUTOS
public class Cliente implements Imprimible {
	private String nombre;
	private String telefono;
	private String correo;

//CONSTRUCTORES
	/**
	 * @param nombre
	 * @param telefono
	 * @param correo
	 */
	public Cliente(String nombre, String telefono, String correo) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}

//METODOS
	// booleano para comprobar que los datos del propietario existan
	public Boolean correcto() {
		if (this.correo != null && nombre != null && telefono != null)
			;
		return true;
	}

	public void imprimirDatos() {
		System.out.println("DATOS DEL PROPIETARIO");
		System.out.println("NOMBRE: " + this.getNombre());
		System.out.println("TELEFONO: " + this.getTelefono());
		System.out.println("CORREO: " + this.getCorreo());
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Cliente other = (Cliente) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

//SETTERS && GETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
