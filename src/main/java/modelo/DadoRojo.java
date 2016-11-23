package main.java.modelo;

public class DadoRojo extends Dado {
	public DadoRojo() {
		caras[0] = new Cara(TipoCara.CEREBRO);
		caras[1] = new Cara(TipoCara.PASOS);
		caras[2] = new Cara(TipoCara.PASOS);
		caras[3] = new Cara(TipoCara.DISPARO);
		caras[4] = new Cara(TipoCara.DISPARO);
		caras[5] = new Cara(TipoCara.DISPARO);
	}
}
