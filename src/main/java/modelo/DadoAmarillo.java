package main.java.modelo;

public class DadoAmarillo extends Dado {

	public DadoAmarillo() {
		caras[0] = new Cara(TipoCara.CEREBRO);
		caras[1] = new Cara(TipoCara.CEREBRO);
		caras[2] = new Cara(TipoCara.PASOS);
		caras[3] = new Cara(TipoCara.PASOS);
		caras[4] = new Cara(TipoCara.DISPARO);
		caras[5] = new Cara(TipoCara.DISPARO);
	}
}
