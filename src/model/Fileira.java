package model;

/**
* Esta classe representa um monte de cartas do tipo Fileira.
*/
public class Fileira extends MonteDeCartas {
	
	public Fileira () {
		super();
	}
	
	/*
	* Esta fun��o sobrescrita implementa como Fileira recebe uma carta.
	* @param carta a ser recebida.
	* @param monte de origem.
	* @return se a carta foi recebida ou não.
	*/
	@Override
	public boolean receberCarta(Carta carta, MonteDeCartas origem) {
		if (!(origem instanceof Estoque)) {
			Carta topo = visualizarCartaDoTopo();
			if (topo != null) {
				if (carta.getNumeracao().getValor() - topo.getNumeracao().getValor() == -1) { // descendente!
					if(!carta.getNaipe().getCor().equals(topo.getNaipe().getCor())) { // cores diferentes!
						this.cartas.push(carta);
						return true;
					}
				}	
				return false;
			}else if (carta.getNumeracao() == Numeracao.REI) { // se est� vazio, s� pode REI
				this.cartas.push(carta);
				return true;
			}
		}
		return false;	
	}
	
	/**
	* Esta fun��o sobrescrita implementa como Fileira deve se comportar ao retirar uma carta do topo.
	* @return carta que foi retirada do topo.
	*/
	@Override
	public Carta retirarCartaDoTopo() {
		if (!cartas.isEmpty()) {
			Carta carta =  this.cartas.pop();
			virarCartaDoTopo();
			
			return carta;
		}
		return null;
	}
	
	/**
	* Esta função permite adicionar uma carta na Fileira sem considerar regras do jogo.
	* @param carta a ser adicionada.
	*/
	public void preencher(Carta carta) {
		this.cartas.push(carta);
	}
	
	/*
	* Esta função permite retirar uma carta da Fileira sem considerar regras do jogo.
	* @return carta retirada.
	*/
	public Carta retirar() {
		if (!cartas.isEmpty()) {
			return this.cartas.pop();
		}
		return null;
	}
	
}
