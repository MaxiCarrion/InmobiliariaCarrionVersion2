package edu.unlz.taller.programacion.tp.individual;

import edu.unlz.taller.programacion.tp.individual.constantes.YaExisteInmuebleException;

public class InmobiliariaTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws YaExisteInmuebleException {
		// Set<Inmueble> inmuebles = new HashSet<Inmueble>();
		Inmobiliaria laDeMaxy = new Inmobiliaria("La de Maxy", 0);

		// se instancian los clientes
		Cliente maxi = new Cliente("maxy", "otroTelefono", "otroMail");
		Cliente maxo = new Cliente("Maxi", "1164903085", "maximilianocarrion@yahoo.com.ar");

		// se instancian los inmuebles
		Inmueble unInmueble = new Inmueble("Otra calle falsa 555", 25, 500.0, false, false, maxi);
		Inmueble otroInmueble = new Inmueble("Calle falsa 321", 30, 200.0, false, false, maxo);
		Inmueble inmuebleVendido = new Inmueble("Calle falsa 123", 30, 100.0, true, true, maxo);
		Inmueble inmuebleTechado = new InmuebleTechado("Una calle 1", 100, 1000.0, true, true, maxi, 5, true, false);

		// agrega inmuebles
		laDeMaxy.agregarInmueble(unInmueble);
		laDeMaxy.agregarInmueble(otroInmueble);

		// quita un inmueble
		laDeMaxy.quitarInmueble(unInmueble);

		// ALGUNAS SALIDAS POR CONSOLA
		System.out.println("ALGUNAS SALIDAS POR CONSOLA");
		System.out.println("");
		// muestro el tamaño actual
		System.out.println("Cantidad de inmuebles actual: " + laDeMaxy.inmuebles.size());

		// agrega mas inmuebles
		laDeMaxy.agregarInmueble(unInmueble);
		laDeMaxy.agregarInmueble(inmuebleVendido);
		laDeMaxy.agregarInmueble(inmuebleTechado);

		// se crea un nuevo arraylist
		// List<Inmueble> unaLista = new ArrayList<Inmueble>();

		// se crea una copia de inmuebles en el arraylist
		// unaLista.addAll(laDeMaxy.inmuebles);

		// intento agregar un inmueble repetido
		laDeMaxy.agregarInmueble(unInmueble);

		// intento agregar otro inmueble ya ingresado
		laDeMaxy.agregarInmueble(inmuebleVendido);
		System.out.println("Cantidad de inmuebles actual: " + laDeMaxy.inmuebles.size());

		// se imprimen todos todos los datos

		laDeMaxy.imprimirDatos();
		laDeMaxy.getInmueblesOrdenadosPorPrecio();

		System.out.println("BENEFICIO ESPERADO: " + laDeMaxy.beneficioEsperado());
		System.out.println("BENEFICIO OBTENIDO: " + laDeMaxy.beneficioObtenido());
	}
}