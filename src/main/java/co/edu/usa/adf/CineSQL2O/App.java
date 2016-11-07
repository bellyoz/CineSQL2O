package co.edu.usa.adf.CineSQL2O;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import co.edu.usa.adf.Daos.PeliculaDao;
import co.edu.usa.adf.Entidades.Pelicula;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
       PeliculaDao pelicula  = new PeliculaDao();
       Pelicula peli = new Pelicula();
       
       peli.setNombre("peli");
       peli.setGenero("terror");
       
       Date fecha = new Date();
       peli.setDuracion(fecha);
       
      /* if(pelicula.insert(peli)){
    	   System.out.println("insertado");
       }else{
    	   System.out.println("pailas soxcio");
       }*/
       
       List<Map<String, Object>> peliculas = pelicula.getAll();
       for (int i=0; i<peliculas.size(); i++){
    	   System.out.println(peliculas.get(i).get("pelicula"));
    	 }
     
    }
}
