package co.edu.usa.adf.CineSQL2O;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import co.edu.usa.adf.Daos.FuncionDao;
import co.edu.usa.adf.Daos.PeliculaDao;
import co.edu.usa.adf.Daos.TicketDao;
import co.edu.usa.adf.Entidades.Funcion;
import co.edu.usa.adf.Entidades.Ticket;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		/*
		 * PeliculaDao pelicula = new PeliculaDao();
		 * 
		 * List<Map<String,Object>> peli = pelicula.getOne(1);
		 * System.out.println("pelicula "+peli.get(0).get("duracion")); /*
		 * if(pelicula.insert(peli)){ System.out.println("insertado"); }else{
		 * System.out.println("pailas soxcio"); }
		 */
		/*
		 * List<Map<String, Object>> peliculas = pelicula.getAll(); for (int i =
		 * 0; i < peliculas.size(); i++) {
		 * System.out.println(peliculas.get(i).get("pelicula")); }
		 */

		/*
		 * SalaDao sala = new SalaDao(); Sala salita = new Sala();
		 * salita.setCapacidad(200);
		 * salita.setDisponible(salita.getCapacidad()); //sala.insert(salita);
		 */

		/*
		 * List<Map<String, Object>> salas = sala.getAll(); for(int i = 0 ;
		 * i<salas.size() ; i++){
		 * System.out.println("sala "+salas.get(i).get("id")); }
		 */

		/*
		 * SillaDao silla = new SillaDao(); Silla sillita = new Silla();
		 * sillita.setFila("a"); sillita.setNumero(2);
		 * sillita.setDisponible(true);
		 * sillita.setSala((int)sala.getAll().get(1).get("id")); //
		 * silla.insert(sillita);
		 * 
		 * List<Map<String, Object>> sillas = silla.getAll(); for(int i= 0 ; i<
		 * sillas.size() ; i++){ System.out.println(sillas.get(i).get("id")); }
		 */
		/*
		 * FuncionDao funcion = new FuncionDao(); Funcion funcionsita = new
		 * Funcion(); funcionsita.setSala(1); funcionsita.setPelicula(1);
		 * funcionsita.setInicio(new Date()); funcion.insert(funcionsita);
		 */
		TicketDao ticket = new TicketDao();
		Ticket ticketsito = new Ticket();
		ticketsito.setFuncion(1);
		ticketsito.setSilla(1);
		ticket.insert(ticketsito);
		System.out.println("fin");
	}
}
