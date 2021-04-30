package controller;

import java.util.ArrayList;

import model.Carta;
import model.MonteDeCartas;
import model.Fundacao;
import model.Fileira;
import model.Estoque;
import model.Descarte;

public class Paciencia {
	
	private static final int QUANTIDADE_FUNDACOES = 4;
	private static final int QUANTIDADE_FILEIRAS = 7;
	/*private int qtdCartasVirarEstoque = 3;*/
	private MonteDeCartas estoque = new Estoque();
	private MonteDeCartas descarte = new Descarte();
	private ArrayList<MonteDeCartas> montes = new ArrayList<MonteDeCartas>(2 + QUANTIDADE_FILEIRAS + QUANTIDADE_FUNDACOES);
	
	public Paciencia() {
		
		montes.add(estoque);
		montes.add(descarte);

		for(int i = 0; i < QUANTIDADE_FUNDACOES; i++) {
			Fundacao fundacao = new Fundacao();
			montes.add(fundacao);
		}
		
		for(int i = 0; i < QUANTIDADE_FILEIRAS; i++) {
			Fileira fileira = new Fileira();
			for(int j = 0; j <= i; j++) {
				Carta carta = estoque.retirarCartaDoTopo();
				fileira.preencher(carta);
			}
			fileira.virarCartaDoTopo();
			montes.add(fileira);
		}
		log();
		for (int i = 0; i < 24; i++) {
			moverCarta(1,2);
		}
		log();
		moverCarta(1,2);
		log();
		moverCarta(1,2);
		log();
	}
	
	/*
	public void definirQtdDeCartasVirarEstoque (int n) {
		qtdCartasVirarEstoque = n;
	}
	
	public void virarCartaEstoque() {
		for (int n = 0; n < qtdCartasVirarEstoque; n++) {
			moverCartaEstoque();
		}
	}
	
	public void moverCartaEstoque() {
		Carta c = estoque.retirarCartaDoTopo();
		if (c != null) {
			descarte.receberCarta(c);
			return;
		}
		while (!descarte.estaVazio()) { 
			Carta c2 = descarte.retirarCartaDoTopo();
			estoque.receberCarta(c2);
		}
		
	}*/
	
	public void moverCarta(int idOrigem, int idDestino) {
		MonteDeCartas origem = montes.get(idOrigem - 1);
		MonteDeCartas destino = montes.get(idDestino - 1);
		
		Carta c = origem.visualizarCartaDoTopo();
		if (c != null) {
			if (destino.receberCarta(c, origem.getClass())) {
				origem.retirarCartaDoTopo();
			}
		}
		else {
			if (origem instanceof Estoque) {
				while (!descarte.estaVazio()) { 
					Carta c2 = descarte.retirarCartaDoTopo();
					Estoque est = (Estoque) estoque;
					est.restabelecer(c2, new Descarte().getClass());
				}
			}	
		}
	}
	
	
	public void log() {

		int idMonte = 1;
		for(MonteDeCartas monte : montes) {
			if (monte instanceof Estoque) {
				System.out.print(idMonte++ + " - Estoque: ");
				System.out.println(monte);
			}
			else if (monte instanceof Descarte) {
				System.out.print(idMonte++ + " - Descarte: ");
				System.out.println(monte);
			}
			else if(monte instanceof Fundacao) {
				System.out.print(idMonte++ + " - Fundação: ");
				System.out.println(monte);
			}else if(monte instanceof Fileira) {
				System.out.print(idMonte++ + " - Fileira: ");
				System.out.println(monte);
			}
			
		}

		System.out.println();
		
	}
	
}
