package co.edu.usa.adf.Daos;

import java.util.List;
import java.util.Map;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import co.edu.usa.adf.Entidades.Pelicula;
import co.edu.usa.adf.Entidades.Ticket;

public class TicketDao {
	private Sql2o sql2o;

	public TicketDao() {
		this.sql2o = new Sql2o("jdbc:mysql://localhost:3306/CineFrame", "root", "uchiha01");

	}

	public Boolean insert(Ticket ticket) {
		String sql = "insert into ticket(id_funcion , id_silla) values (:id_funcion , :id_silla )";
		try (Connection con = sql2o.open()) {
			if (validarSilla(ticket.getFuncion(), ticket.getSilla())) {
				con.createQuery(sql, true).addParameter("id_funcion", ticket.getFuncion())
						.addParameter("id_silla", ticket.getSilla()).executeUpdate();
				asignarSilla(ticket.getFuncion(), ticket.getSilla());
			}

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Map<String, Object>> getAll() {
		String sql = "SELECT pelicula, genero, duracion FROM pelicula";

		try (Connection con = sql2o.open()) {
			return con.createQuery(sql).executeAndFetchTable().asList();
		}
	}

	private  void asignarSilla(int idFuncion, int id) {
		FuncionDao funcion = new FuncionDao();
		SillaDao silla = new SillaDao();
		int idSala = (int) funcion.getOne(idFuncion).get(0).get("id_sala");
		silla.update(id, idSala);

	}

	private boolean validarSilla(int idFuncion, int id) {
		FuncionDao funcion = new FuncionDao();
		SillaDao silla = new SillaDao();
		int idSala = (int) funcion.getOne(idFuncion).get(0).get("id_sala");
		List<Map<String, Object>> si = silla.getOne(id, idSala);
		return (boolean) si.get(0).get("disponible");
	}
}
