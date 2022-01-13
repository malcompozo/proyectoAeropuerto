package proyectoAeropuerto;

public class Compania {

	//	VARIABLES
	private String nombre;
	private int numVuelo = 0;
	private Vuelo listaVuelo[] = new Vuelo[10];
	
	
	//	METODO CONSTRUCTOR
	public Compania(String nombre) {
		this.nombre = nombre;
	}
	public Compania(String nombre, Vuelo vuelo[]) {
		this.nombre = nombre;
		listaVuelo = vuelo;
		numVuelo = vuelo.length;
	}
	
	
	//	GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}
	public int getNumVuelo() {
		return numVuelo;
	}
	public Vuelo[] getListaVuelo() {
		return listaVuelo;
	}
	
	
	//	METODO PARA INSERTAR UN VUELO
	public void insertarVuelo(Vuelo vuelo) {
		listaVuelo[numVuelo] = vuelo;
		numVuelo++;
	}
	
	
	// 	OBTENER UN VUELO POR SU POSICION EN EL ARREGLO
	public Vuelo getVuelo(int i) {
		return listaVuelo[i];
	}
	
	
	//	(SOBRECARGA DE METODOS) OBTENER UN VUELO POR NUMERO DE ID
	public Vuelo getvuelo(String id) {
		Vuelo vuelo=null;
		boolean flag = false;
		int i=0; // inicializo una variable de iteracion 
		
		while (i<listaVuelo.length && !flag)  { // comparo la variable con el largo del arreglo y que la bandera sea falsa
			if (id.equals(listaVuelo[i].getIdentificador())) { // comparo el dato pasado por parametro con la iteracion del arreglo
				flag = true; // cambio la bandera a true
				vuelo=listaVuelo[i]; // se guarda el pasajero en la posicion del iterador i
			}
			i++;//aunmento en 1 la variable de iteracion en cada vuelta
		}
		return vuelo;
	}
	
	
}
