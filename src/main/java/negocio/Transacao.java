package negocio;

import java.util.ArrayList;

public class Transacao {
	protected  ArrayList<Locacao> alugueis;

	
	public Transacao() {
		alugueis = new ArrayList<Locacao>();
	}
	
	public void addLocacao (Locacao l) {
		alugueis.add(l);
	}

	int qntGeneroAparece(ArrayList<Locacao> alugueis, Genero genero) {
		int valor = 0;
		for(Locacao locacao: alugueis) {
		
			if(locacao.movie.genero == genero) {
				valor++;
			}
		}
		return valor;
	}
	
	public Genero MaisAlugado() {
		int valor = 0;
		Genero mostRented = null;
		int aux = 0;
		int x;
		for(Genero genero: Genero.values()) {
			valor = qntGeneroAparece(alugueis, genero);
			
			if(valor > aux) {
				aux = valor;
				mostRented = genero;
			}
			
		}
		return mostRented;
	}

	
	public int valorLocacaoTotal() {
	
	    int valor=0;
		for (Locacao locacao : alugueis) {
			valor += locacao.movie.value;
		}
		return valor;
	}
	
}
