package main.java.modelo;

import java.util.ArrayList;
import java.util.List;

public class Partida {
	private int VERDES = 6;
	private int AMARILLOS = 4;
	private int ROJOS = 3;
	private int PUNTUACION_VICTORIA = 20;

	private List<Dado> dados;
	private List<Dado> dadosTirados;
	private List<Jugador> jugadores;
	private int turno;

	private int numCerebros;
	private int numDisparos;
	private int numPasos;

	public Partida() {
		turno = 0;
		estadoInicial();

		dados = new ArrayList<Dado>();
		jugadores = new ArrayList<Jugador>();

		for (int i = 0; i < VERDES; i++) {
			dados.add(new DadoVerde());
		}
		for (int i = 0; i < AMARILLOS; i++) {
			dados.add(new DadoAmarillo());
		}
		for (int i = 0; i < ROJOS; i++) {
			dados.add(new DadoRojo());
		}
	}

	public void addJugador(String nombre) {
		jugadores.add(new Jugador(nombre));
	}

	public boolean tirarDados() {
		boolean fin = false;
		Dado dado;
		Cara cara;
		int aleatorio = (int) Math.round(Math.random() * dados.size());
		for (int i = 0; i < 3; i++) {
			if (hayDados()) {
				dado = dados.remove(aleatorio);
				cara = dado.tirar();
				comprobarCara(cara);
				if (dado.estaTirado()) {
					dadosTirados.add(dado);
				} else {
					dados.add(dado);
				}
			}
		}

		if (estaMuerto() || haGanado()) {
			fin = true;
		}
		return fin;
	}

	private void comprobarCara(Cara cara) {
		comprobarSiCerebro(cara);
		comprobarSiDisparo(cara);
		comprobarSiPasos(cara);
	}

	private void comprobarSiCerebro(Cara cara) {
		if (cara.getTipo() == TipoCara.CEREBRO) {
			numCerebros++;
		}
	}

	private void comprobarSiDisparo(Cara cara) {
		if (cara.getTipo() == TipoCara.DISPARO) {
			numDisparos++;
		}
	}

	private void comprobarSiPasos(Cara cara) {
		if (cara.getTipo() == TipoCara.PASOS) {
			numPasos++;
		}
	}

	private boolean hayDados() {
		if (dados.size() > 0) {
			return true;
		}
		return false;
	}

	public boolean acabarJugada() {
		boolean fin = false;
		Jugador jugadorActual = jugadores.get(turno);
		if (estaMuerto()) {
			reiniciarDados();
		} else {
			jugadorActual.aumentarPuntuacion(numCerebros);
		}

		estadoInicial();
		fin = haGanado();
		pasarTurno();
		return fin;
	}

	private void estadoInicial() {
		numCerebros = 0;
		numDisparos = 0;
		numPasos = 0;
	}

	private boolean estaMuerto() {
		if (numDisparos >= 3) {
			return true;
		}
		return false;
	}

	private boolean haGanado() {
		Jugador jugador = jugadores.get(turno);
		if (jugador.getPuntuacion() >= PUNTUACION_VICTORIA) {
			return true;
		}
		return false;
	}

	private void pasarTurno() {
		int ultimoJugador = jugadores.size() - 1;
		if (turno == ultimoJugador) {
			turno = 0;
		} else {
			turno++;
		}
	}

	private void reiniciarDados() {
		for (Dado d : dadosTirados) {
			d.reiniciarDado();
			dados.add(d);
		}
	}

}
