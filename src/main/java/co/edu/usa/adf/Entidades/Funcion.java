package co.edu.usa.adf.Entidades;

import java.util.Date;

public class Funcion {
	private long id;
	private int sala;
	private int  pelicula;
	private Date inicio;
	private Date fin;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public int getPelicula() {
		return pelicula;
	}

	public void setPelicula(int pelicula) {
		this.pelicula = pelicula;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

}
