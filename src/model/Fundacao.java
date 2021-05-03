package model;

/*
* Esta classe representa um monte de cartas do tipo Fundacao.
*/
public class Fundacao extends MonteDeCartas{

	public Fundacao () {
		super();
	}
	
	/*
	* Esta fun��o sobrescrita implementa como Fundacao recebe uma carta.
	* @param carta a ser recebida.
	* @param monte de origem.
	* @return se a carta foi recebida ou n�o.
	*/
	@Override
	public boolean receberCarta(Carta carta, MonteDeCartas origem) {
		if (!(origem instanceof Estoque)) {
			Carta topo = visualizarCartaDoTopo();
			if (topo != null) {
				if (carta.getNumeracao().getValor() - topo.getNumeracao().getValor() == 1) {
					if(carta.getNaipe().getCor().equals(topo.getNaipe().getCor())) {
						this.cartas.push(carta);
						return true;
					}
				}	
				return false;
			} else if (carta.getNumeracao() == Numeracao.AS) {
				this.cartas.push(carta);
				return true;
			}
		}
		return false;
	}
	
	/**
	* Este m�todo retorna se a Fundacao est� completa.
	* @return se est� completa ou não.
	*/
	public boolean estaCompleta() {
		return (cartas.size() == 13);
	}
	
}
