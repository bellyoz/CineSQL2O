package co.edu.usa.adf.Daos;

import java.util.List;
import java.util.Map;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import co.edu.usa.adf.Entidades.Pelicula;
import co.edu.usa.adf.Entidades.Sala;

public class SalaDao {
	private Sql2o sql2o;

	public SalaDao() {
		this.sql2o = new Sql2o("jdbc:mysql://localhost:3306/CineFrame", "root", "uchiha01");

	}

	public Boolean insert(Sala sala) {
		String sql = "insert into sala(capacidad , disponible ) values (:capacidad , :disponible)";
		try (Connection con = sql2o.open()) {
			con.createQuery(sql, true).addParameter("capacidad", sala.getCapacidad())
					.addParameter("disponible", sala.getDisponible()).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Map<String, Object>> getAll() {
		String sql = "SELECT id ,capacidad, disponible FROM sala";

		try (Connection con = sql2o.open()) {
			return con.createQuery(sql).executeAndFetchTable().asList();
		}
	}
}
