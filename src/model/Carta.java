package model;

public class Carta {
	Naipe naipe;
	Valor valor;
	Lado lado;
	
	public Carta(Naipe naipe, Valor valor) {
		this.naipe = naipe;
		this.valor = valor;
		this.lado = Lado.BAIXO;
	}

	public Naipe getNaipe() {
		return naipe;
	}

	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}

	public Lado getLado() {
		return lado;
	}

	public void setLado(Lado lado) {
		this.lado = lado;
	}
	
	
}
