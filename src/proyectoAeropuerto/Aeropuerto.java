package proyectoAeropuerto;

public abstract class Aeropuerto {

	//	VARIABLES
	private String nombre;
	private String ciudad;
	private String pais;
	private Compania listaCompania[] = new Compania[10];
	private int numCompania;
	
	
	//	METODO CONSTRUCTOR
	public Aeropuerto(String nombre, String ciudad, String pais) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.numCompania = 0;
	}

	public Aeropuerto(String nombre, String ciudad, String pais, Compania[] listaCompania) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.numCompania = 0;
		this.listaCompania = listaCompania;
	}
	
	
	//	METODO PARA INSERTAR UNA COMPAÑIA
	public void insertarCompania(Compania compania) {
		listaCompania[numCompania] = compania;
		numCompania++;
	}

	
	//	GETTERS
	public String getNombre() {
		return nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getPais() {
		return pais;
	}

	public Compania[] getListaCompania() {
		return listaCompania;
	}

	public int getNumCompania() {
		return numCompania;
	}
	
	// 	METODO PARA RETORNAR COMPAÑIA SEGUN SU NUMERO DE ITERADOR
	public Compania getCompania(int i) {
		return listaCompania[i];
	}
	
	//	(SOBRECARGA DE METODOS) OBTENER UNA COMPAÑIA POR SU NOMBRE
	public Compania getCompania(String nom) {
		Compania nombre=null;
		boolean flag = false;
		int i=0; // inicializo una variable de iteracion 
		
		while (i<listaCompania.length && !flag)  { // comparo la variable con el largo del arreglo y que la bandera sea falsa
			if (nom.equals(listaCompania[i].getNombre())) { // comparo el dato pasado por parametro con la iteracion del arreglo
				flag = true; // cambio la bandera a true
				nombre=listaCompania[i]; // se guarda el pasajero en la posicion del iterador i
			}
			i++;//aunmento en 1 la variable de iteracion en cada vuelta
		}
		return nombre;
	}
	
	
	
	
	
	
}
