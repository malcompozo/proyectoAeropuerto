package proyectoAeropuerto;

public class AeropuertoPrivado extends Aeropuerto{

	
	//	VARIABLES
	private String listaEmpresas[] = new String[10];
	private int numEmpresas;
	
	
	//	 METODOS CONSTRUCTOR
	public AeropuertoPrivado(String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);
	}

	public AeropuertoPrivado(String nombre, String ciudad, String pais, Compania[] listaCompania, String[] listaEmpresas) {
		super(nombre, ciudad, pais, listaCompania);
		this.listaEmpresas = listaEmpresas;
		this.numEmpresas = listaEmpresas.length;
	}
	
	//	METODO PARA INSERTAR TODAS LAS EMPRESAS
	public void insertarEmpresas(String empresa[]) {
		this.listaEmpresas = empresa;
		this.numEmpresas = empresa.length; 
	}
	
	//	METODO PARA INSERTAR EMPRESA 1 POR 1
	public void insertarEmpresa(String empresa) {
		listaEmpresas[numEmpresas]=empresa; 
		numEmpresas++;
	}

	//	 GETTERS
	public String[] getListaEmpresas() {
		return listaEmpresas;
	}

	public int getNumEmpresas() {
		return numEmpresas;
	}
	
	
}
