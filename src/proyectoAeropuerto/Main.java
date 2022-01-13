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
					
				case 2:
						break;
					
				case 3:
						break;
					
				case 4:
						break;
					
				case 5:
						break;
					
				case 6: // SALIR
						break;
					
				default:
						throw new IllegalArgumentException("Unexpected value: " + op);
			}
			System.out.println("");
		} while (op!=6);
	}
	
	
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
}
