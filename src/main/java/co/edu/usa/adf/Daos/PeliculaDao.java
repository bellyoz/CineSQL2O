package co.edu.usa.adf.Daos;





import java.util.List;
import java.util.Map;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import co.edu.usa.adf.Entidades.Pelicula;

public class PeliculaDao {
	private Sql2o sql2o;
	public PeliculaDao() {
		this.sql2o = new Sql2o("jdbc:mysql://localhost:3306/CineFrame", "root", "uchiha01");
		
	}

	public Boolean insert(Pelicula pelicula) {
		String sql = "insert into pelicula(pelicula , genero , duracion) values (:pelicula , :genero , :duracion)";
		try(Connection con = sql2o.open()){
			 con.createQuery(sql, true)
					    .addParameter("pelicula" , pelicula.getNombre())
					    .addParameter("genero", pelicula.getGenero())
					    .addParameter("duracion", pelicula.getDuracion())
					    .executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	public List<Map<String , Object>> getAll(){
		String sql =
		        "SELECT pelicula, genero, duracion FROM pelicula";

		    try(Connection con = sql2o.open()) {
		        return con.createQuery(sql).executeAndFetchTable().asList();
		    }
	}
	public List<Map<String , Object>> getOne(long id){
		String sql = "Select id , pelicula , genero , duracion from pelicula where id = "+id;
		try(Connection con = sql2o.open()){
			return con.createQuery(sql).executeAndFetchTable().asList();
		}
		
	}
}
