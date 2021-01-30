package edu.unlz.taller.programacion.tp.individual;

import java.util.*;

import edu.unlz.taller.programacion.tp.individual.constantes.Constantes;
import edu.unlz.taller.programacion.tp.individual.constantes.Imprimible;
import edu.unlz.taller.programacion.tp.individual.constantes.YaExisteInmuebleException;

//ATRIBUTOS
public class Inmobiliaria implements Imprimible {

	private String nombre;
	private Integer cantidadDeInmuebles;
	private Integer MAXIMO_DE_INMUEBLES;
	private Double COMISION;
	protected Set<Inmueble> inmuebles;

// CONSTRUCTOR
	/**
	 * @param nombre
	 * @param cantidadDeInmuebles
	 * @param inmuebles
	 */
	public Inmobiliaria(String nombre, Integer cantidadDeInmuebles) {
		this.nombre = nombre;
		this.cantidadDeInmuebles = cantidadDeInmuebles;
		this.inmuebles = new HashSet<Inmueble>();
		this.COMISION = Constantes.COMISION;
		this.MAXIMO_DE_INMUEBLES = Constantes.MAXIMO_DE_INMUEBLES;

	}

//METODOS

	public void agregarInmueble(Inmueble unInmueble) throws YaExisteInmuebleException {
		if (this.inmuebles.contains(unInmueble) == false) {
			this.inmuebles.add(unInmueble);
			this.cantidadDeInmuebles++;
		} else {
			new YaExisteInmuebleException();
		}
	}

	// quita un inmueble existente
	public void quitarInmueble(Inmueble unInmueble) {
		if (this.inmuebles.contains(unInmueble)) {
			this.inmuebles.remove(unInmueble);
			this.cantidadDeInmuebles--;
		}
	}

	// benecifio esperado (no incluye los inmuebles vendidos)
	public Double beneficioEsperado() {
		Double beneficioEsperado = 0.0;
		for (Inmueble unInmueble : this.inmuebles) {
			if (unInmueble.getVendido() == false && unInmueble.getReservado() == false) {
				beneficioEsperado += unInmueble.beneficioEsperado(this.getCOMISION());
			}
		}
		return beneficioEsperado;
	}

	// beneficio obtenido (solo inmuebles vendidos o reservados)

	public Double beneficioObtenido() {
		Double beneficioObtenido = 0.0;
		for (Inmueble unInmueble : this.inmuebles) {
			if (unInmueble.getVendido() || unInmueble.getReservado()) {
				beneficioObtenido += unInmueble.beneficioObtenido(this.getCOMISION());
			}
		}
		return beneficioObtenido;
	}

	// imprimir datos
	public void imprimirDatos() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("DATOS DE LA INMOBILIARIA");
		System.out.println("");
		System.out.println("NOMBRE DE LA INMOBILIARIA: " + this.getNombre());
		System.out.println("CANTIDAD DE INMUEBLES: " + this.getCantidadDeInmuebles());
		System.out.println("CANTIDAD MAXIMA DE INMUEBLES: " + this.MAXIMO_DE_INMUEBLES);
		System.out.println("COMISION: " + this.COMISION);
		System.out.println(" ");
		System.out.println(" ");
		/*
		 * for (Inmueble inmueble : inmuebles) { if (inmueble != null) {
		 * System.out.println("DATOS DEL INMUEBLE"); inmueble.imprimirDatos(); } }
		 */

	}

	public List<Inmueble> getInmueblesOrdenadosPorPrecio()
	/* public void getInmueblesOrdenadosPorPrecio(List<Inmueble> unaLista) */ {
		List<Inmueble> unaLista = new ArrayList<Inmueble>();
		unaLista.addAll(inmuebles);
		Collections.sort(unaLista);
		System.out.println("INMUEBLES ORDENADOS POR PRECIO");
		System.out.println("");
		for (Inmueble inmueble : unaLista) {
			if (inmuebles.isEmpty() == false) {
				inmueble.imprimirDatos();
			}
		}
		return unaLista;

	}

// SETTERS && GETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidadDeInmuebles() {
		return cantidadDeInmuebles;
	}

	public void setCantidadDeInmuebles(Integer cantidadDeInmuebles) {
		this.cantidadDeInmuebles = cantidadDeInmuebles;
	}

	public Integer getMAXIMO_DE_INMUEBLES() {
		return MAXIMO_DE_INMUEBLES;
	}

	public Double getCOMISION() {
		return COMISION;
	}

	public Set<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(Set<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

}
