package co.edu.usa.adf.Daos;





import java.util.List;
import java.util.Map;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import co.edu.usa.adf.Entidades.Pelicula;
import co.edu.usa.adf.Entidades.Silla;

public class SillaDao {
	private Sql2o sql2o;
	public SillaDao() {
		this.sql2o = new Sql2o("jdbc:mysql://localhost:3306/CineFrame", "root", "uchiha01");
		
	}

	public Boolean insert(Silla silla) {
		String sql = "insert into silla(fila,numero,disponible , id_sala) values (:fila , :numero ,:disponible, :id_sala)";
		try(Connection con = sql2o.open()){
			 con.createQuery(sql, true)
					    .addParameter("fila" , silla.getFila())
					    .addParameter("numero", silla.getNumero())
					    .addParameter("disponible", silla.isDisponible())
					    .addParameter("id_sala", silla.getSala())
					    .executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	public void update(int id , int sala){
		String updateSql = "update silla set disponible = :disponible where id = :idParam && id_sala = :idSala";

		try (Connection con = sql2o.open()) {
		    con.createQuery(updateSql)
			    .addParameter("disponible", false)
			    .addParameter("idParam", id)
			    .addParameter("idSala", sala)
			    .executeUpdate();
		}
	}
	public List<Map<String , Object>> getAll(){
		String sql =
		        "SELECT id , fila , numero ,disponible , id_sala FROM silla";

		    try(Connection con = sql2o.open()) {
		        return con.createQuery(sql).executeAndFetchTable().asList();
		    }
	}
	public List<Map<String , Object>> getOne(long id , int sala){
		String sql = "Select id , fila , numero ,disponible , id_sala FROM silla where id = "+id+" && id_sala = "+sala;
		try(Connection con = sql2o.open()){
			return con.createQuery(sql).executeAndFetchTable().asList();
		}
		
	}
}
