package proyectoAeropuerto;

import java.util.Iterator;
import java.util.Scanner;


public class Main {
	static Scanner scanner= new Scanner(System.in);
	final static int numAeropuerto = 2; // NUMERO DE AEROPUERTOS
	static Aeropuerto aeropuerto[]= new Aeropuerto[numAeropuerto]; // INSTANCIAMOS E INICIAMOS UN ARREGLO 
	
	
	public static void main(String[] args) {
		
		//	INSERTAR DATOS DE LOS AEROPUERTOS
		insertarDatos(aeropuerto);
		
		//	MENU
		menu();
	}

	public static void insertarDatos(Aeropuerto aero[]) {
		
		// CREAMOS UN AEROPUERTO PUBLICO
		aero[0] = new AeropuertoPublico("asdasd", "123", "$hule", 8000000); 
		aero[0].insertarCompania(new Compania("Aero$hule")); //	CREAMOS UNA COMPAÑIA Y LA INSERTAMOS
		aero[0].insertarCompania(new Compania("Eskai")); //	CREAMOS OTRA COMPAÑIA
		
		//	VERIFICAMOS SI LA COMPAÑIA EXISTE E INSERTAMOS UN NUEVO ARREGLO
		aero[0].getCompania("Aero$hule").insertarVuelo(new Vuelo("SH12", "$hule", "Estados Petroleros de America", 150.5, 100));
		aero[0].getCompania("Eskai").insertarVuelo(new Vuelo("ES23", "$hule", "Odin city", 120.5, 120));
		
		//	VERIFICAMOS LA COMPAÑIA, EL ID DEL VUELO Y POR ULTIMO INSERTAMOS UN PASAJERO
		aero[0].getCompania("Aero$hule").getvuelo("SH12").insertarPasajero(new Pasajero("marlon", "asd123", "$huleno"));;
		
		
		
		// CREAMOS UN AEROPUERTO PRIVADO
		aero[1] = new AeropuertoPrivado("cuico", "santiasco", "chule");
		aero[1].insertarCompania(new Compania("$hules cuicos")); //	CREAMOS UNA COMPAÑIA Y LA INSERTAMOS
		aero[1].insertarCompania(new Compania("Eskai premium")); //	CREAMOS OTRA COMPAÑIA
				
		//	VERIFICAMOS SI LA COMPAÑIA EXISTE E INSERTAMOS UN NUEVO ARREGLO
		aero[1].getCompania("$hules cuicos").insertarVuelo(new Vuelo("ABC1", "$hule", "chilezuela", 250.5, 120));
		aero[1].getCompania("Eskai premium").insertarVuelo(new Vuelo("ABC2", "$hule", "cuba", 220.5, 90));
			
		//	VERIFICAMOS LA COMPAÑIA, EL ID DEL VUELO Y POR ULTIMO INSERTAMOS UN PASAJERO
		aero[1].getCompania("$hules cuicos").getvuelo("ABC1").insertarPasajero(new Pasajero("marlon istopo", "asd123", "$huleno"));;
	}
	
	public static void menu() {
		
		int op;
		
		do {
			System.out.println("\t.:MENU:.");
			System.out.println("1) Ver aeropuertos creados");
			System.out.println("2) Ver empresas (privado) o subvencion(publico)");
			System.out.println("3) Lista de compañias de un aeropuerto");
			System.out.println("4) Mostrar lista de vuelo por compañia");
			System.out.println("5) Lista posibles vuelos (origen / destino)");
			System.out.println("6) SALIR");
			System.out.print("\n ¿Opción?");
			op=scanner.nextInt();
			
			switch (op) {
			
				case 1: System.out.println("");
				 		mostrarAeropuertos(aeropuerto);
						break;
					
				case 2:	System.out.println("");
						verEmpresas(aeropuerto);
						break;
					
				case 3:	scanner.nextLine();
						System.out.print("\n Digite el nombre del aeropuerto: ");
				 		nomAero = scanner.nextLine(); // PREGUNTAMOS EL NOMBRE DE LA COMPAÑIA QUE DESEA BUSCAR
				 		aero = listaVuelosAeropuerto(nomAero, aeropuerto);
				 		
				 		if (aero==null) { // CONDICIONAL 
							System.out.println("El aeropuerto buscado no existe");
						} else {
							
							//	LISTA DE COMPAÑIAS POR AEROPUERTO
							mostrarCompanias(aero);
						}
						break;
					
				case 4:	scanner.nextLine();
						System.out.println("\n Digite el nombre del aeropuerto: ");
				 		nomAero = scanner.nextLine(); // PREGUNTAMOS EL NOMBRE DE LA COMPAÑIA QUE DESEA BUSCAR
				 		aero = listaVuelosAeropuerto(nomAero, aeropuerto);
				 		
				 		if (aero==null) { // CONDICIONAL 
							System.out.print("El aeropuerto buscado no existe");
						} else {
							//	LISTA DE VUELOS POR COMPAÑIA
							System.out.print("Digite nombre de la compañia: ");
							nomCompania= scanner.nextLine();
							
							//	BLOQUE TRY CATCH PARA TRATAR ERRORES
							try {
								compania = aero.getCompania(nomCompania);
							} catch (Exception e) {
								System.out.println("El aeropuerto no existe");
							} finally {
								if (compania!=null) {
									listarVueloCompania(compania);
								}
								
							}
							
						}
						break;
					
				case 5:
						break;
					
				case 6: // SALIR
						System.out.println("¡Adiós!");
						break;
					
				default:
						throw new IllegalArgumentException("Unexpected value: " + op);
			}
			System.out.println("");
		} while (op!=6);
	}
	

	//	---------------------- OPCION 1 ----------------------
	
	public static void mostrarAeropuertos(Aeropuerto aeropuerto[]) {
		for (int i = 0; i < aeropuerto.length; i++) {
			if (aeropuerto[i] instanceof AeropuertoPrivado) { // CON "instanceof" DETERMINAMOS SI "aeropuerto[i]" PERTENECE A LA CLASE
				System.out.println("Aeropuerto Privado");
				System.out.println("Nombre: "+aeropuerto[i].getNombre());
				System.out.println("Ciudad: "+aeropuerto[i].getCiudad());
				System.out.println("Pais: "+aeropuerto[i].getPais());
			} else {
				System.out.println("Aeropuerto Publico");
				System.out.println("Nombre: "+aeropuerto[i].getNombre());
				System.out.println("Ciudad: "+aeropuerto[i].getCiudad());
				System.out.println("Pais: "+aeropuerto[i].getPais());
			}
			System.out.println("");
		}
	}
	
	
	//	---------------------- OPCION 2 ----------------------
	public static void verEmpresas(Aeropuerto aeropuerto[]) {
		String empresas[];
		
		for (int i = 0; i < aeropuerto.length; i++) {
			if (aeropuerto[i] instanceof AeropuertoPrivado) { // CON "instanceof" DETERMINAMOS SI "aeropuerto[i]" PERTENECE A LA CLASE
				System.out.println("Aeropuerto Privado "+aeropuerto[i].getNombre());
				empresas = ((AeropuertoPrivado)aeropuerto[i]).getListaEmpresas(); //	DOWNCASTING PARA ACCEDER A LOS METODOS DE LA CLASE, GUARDAMOS EN EL ARREGLO 
				System.out.println("Empresas: ");
				for (int j = 0; j < empresas.length; j++) { //	RECORREMOS EL ARREGLO 
					System.out.println(empresas[j]);
				}
				
			} else {
				System.out.println("Aeropuerto Publico "+aeropuerto[i].getNombre());
				System.out.println("Subvencion: "+((AeropuertoPublico)aeropuerto[i]).getSubvencion());
				
			}
			System.out.println("");
		}
		
	}
	
	
	//	---------------------- OPCION 3 ----------------------
	public static Aeropuerto listaVuelosAeropuerto(String nomAero, Aeropuerto aeropuerto[]) {
		int i=0;
		boolean flag=false;
		Aeropuerto aero = null;
		
		//	BUSQUEDA SECUENCIAL
		while ((i<aeropuerto.length) && (!flag)) {
			if (nomAero.equals(aeropuerto[i].getNombre())) {
				flag=true;
				aero=aeropuerto[i];
			}
			i++;
		}
		return aero;
	
	}
	 
	public static void mostrarCompanias(Aeropuerto aeropuerto) {
		
		System.out.println("Las compañias del aeropuerto "+aeropuerto.getNombre()+" son: ");
		for (int i = 0; i < aeropuerto.getNumCompania(); i++) {
			System.out.println(aeropuerto.getCompania(i).getNombre());
		}
	}
	
	
	//	---------------------- OPCION 4 ----------------------
	private static void listarVueloCompania(Compania compania) {
		Vuelo vuelo;
		
		System.out.println("Los vuelos de la compañia "+compania.getNombre()+" son: ");
		for (int i = 0; i < compania.getNumVuelo(); i++) {
			vuelo = compania.getVuelo(i);
			System.out.println("Identificador de vuelo: "+vuelo.getIdentificador());
			System.out.println("Ciudad de origen: "+ vuelo.getCiudadOrigen());
			System.out.println("Ciudad de destino: "+ vuelo.getCiudadDestino());
			System.out.println("Valor: "+ vuelo.getPrecio());
		}
		System.out.println("");
		
	}
	
}
