package main.java.modelo;

public abstract class Dado {
	protected Cara caras[];
	private Cara caraSalida;

	public Dado() {
		caraSalida = null;
	}

	public Cara tirar() {
		caraSalida = caras[(int) Math.round(Math.random() * 6)];
		return caraSalida;
	}

	public boolean estaTirado() {
		if (caraSalida == null) {
			return true;
		}
		return false;
	}

	public void reiniciarDado() {
		caraSalida = null;
	}

	public String toString() {
		return "[" + caras[0].toString() + "]" + "[" + caras[1].toString() + "]" + "[" + caras[2].toString() + "]" + "["
				+ caras[3].toString() + "]" + "[" + caras[4].toString() + "]" + "[" + caras[5].toString() + "]";
	}

}
