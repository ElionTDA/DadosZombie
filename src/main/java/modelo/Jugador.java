package main.java.modelo;

public class Jugador {
	private String nombre;
	private int puntuacion;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void aumentarPuntuacion(int valor) {
		this.puntuacion += valor;
	}
}
