package co.edu.usa.adf.Daos;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import co.edu.usa.adf.Entidades.Funcion;
import co.edu.usa.adf.Entidades.Pelicula;

public class FuncionDao {
	private Sql2o sql2o;

	public FuncionDao() {
		this.sql2o = new Sql2o("jdbc:mysql://localhost:3306/CineFrame", "root", "uchiha01");

	}

	public Boolean insert(Funcion funcion) {

		PeliculaDao pelicula = new PeliculaDao();

		List<Map<String, Object>> peli = pelicula.getOne(funcion.getPelicula());
		Date fin = getFin(funcion.getInicio(), funcion.getInicio().getHours(), funcion.getInicio().getMinutes());
		funcion.setFin(fin);
		String sql = "insert into funcion(id_sala , id_pelicula , inicio , fin) values (:id_sala , :id_pelicula , :inicio , :fin)";
		try (Connection con = sql2o.open()) {
			con.createQuery(sql, true).addParameter("id_sala", funcion.getSala())
					.addParameter("id_pelicula", funcion.getPelicula()).addParameter("inicio", funcion.getInicio())
					.addParameter("fin", funcion.getFin()).executeUpdate();
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

	public Date getFin(Date fecha, int hora, int minutos) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.HOUR, hora);
		calendar.add(Calendar.MINUTE, minutos);

		Date rta = new Date(calendar.getTimeInMillis());

		return rta;
	}
}
