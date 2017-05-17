package br.com.ufsc.pdvfast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estoque implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quantidade;
	List<Produto> produtosCadastrados;

	public Estoque(int quantidade) {
		produtosCadastrados = new ArrayList<Produto>();
		setQuantidade(quantidade);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
