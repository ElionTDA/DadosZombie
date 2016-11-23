package main.java.modelo;

public class DadoVerde extends Dado {

	public DadoVerde() {
		caras[0] = new Cara(TipoCara.CEREBRO);
		caras[1] = new Cara(TipoCara.CEREBRO);
		caras[2] = new Cara(TipoCara.CEREBRO);
		caras[3] = new Cara(TipoCara.PASOS);
		caras[4] = new Cara(TipoCara.PASOS);
		caras[5] = new Cara(TipoCara.DISPARO);
	}
}
