package model;

import java.util.Stack;

/*
* Esta classe representa um monte de cartas.
*/
public class MonteDeCartas {
	
	protected Stack<Carta> cartas; // um monte � representado por uma pilha
	
	public MonteDeCartas() {
		this.cartas = new Stack<Carta>();
	}
	
	/**
	* Esta fun��o define como o monte de cartas deve receber uma carta.
	* @param carta a ser recebida.
	* @param monte de origem.
	* @return se a carta foi recebida ou não
	*/
	public boolean receberCarta(Carta carta, MonteDeCartas origem) {
		this.cartas.push(carta);
		return true;
	}
	
	/*
	* Esta fun��o permite retirar uma carta do topo.
	* @return carta do topo que foi retirada.
	*/
	public Carta retirarCartaDoTopo() {
		if (!cartas.isEmpty()) {
			return this.cartas.pop();
		}
		return null;
	}
	
	/*
	* Esta fun��o permite visualizar uma carta do topo.
	* @return carta do topo para visualiza��o.
	*/
	public Carta visualizarCartaDoTopo() {
		if (!cartas.isEmpty()) {
			return this.cartas.peek();
		}
		return null;
	}
	
	/*
	* Esta fun��o permite virar uma carta do topo.
	* @return carta do topo que foi virada.
	*/
	public Carta virarCartaDoTopo() {
		Carta topo = visualizarCartaDoTopo();
		
		if(!estaVazio()) {
			topo.mostrar();
		}
		
		return topo;
	}
	
	/*
	* Esta fun��o retorna se o monte est� vazio.
	* @return se est� vazio ou n�o.
	*/
	public boolean estaVazio() {
		return cartas.isEmpty();
	}
	
	
	@Override
	public String toString() {
		String visualizacao = cartas.toString();
		
		if (visualizacao.length() > 2) return visualizacao.substring(1, visualizacao.length() - 1);
		return "";
	}
	
}
