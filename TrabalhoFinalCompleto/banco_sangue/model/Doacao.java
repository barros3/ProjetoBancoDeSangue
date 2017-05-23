package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Doacao extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	public ArrayList<NovaDoacao> listaDoacao;
	private Pessoa pessoaDoar;
	private int indice;
	
	public Doacao(){
		this.listaDoacao = new ArrayList<NovaDoacao>();
		setPessoaDoar(new Pessoa());
	}
	
	public ArrayList<NovaDoacao> getListaDoacao() {
		return listaDoacao;
	}
	public void setListaDoacao(ArrayList<NovaDoacao> listaDoacao) {
		this.listaDoacao = listaDoacao;
	}
	public Pessoa getPessoaDoar() {
		return pessoaDoar;
	}
	public void setPessoaDoar(Pessoa pessoaDoar) {
		this.pessoaDoar = pessoaDoar;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
		

}
