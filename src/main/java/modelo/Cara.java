package main.java.modelo;

public class Cara {
	private TipoCara tipo;

	public Cara(TipoCara tipo) {
		this.tipo = tipo;
	}

	public TipoCara getTipo() {
		return tipo;
	}

	public void setTipo(TipoCara tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "" + tipo;
	}

}
