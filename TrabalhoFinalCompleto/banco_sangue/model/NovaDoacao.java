package model;

import java.io.Serializable;

public class NovaDoacao extends Doacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idDoacao;
	private Doacao doacao;
	private double qtd;
	
	public NovaDoacao() {
		this.doacao = new Doacao();
	}
	
	public int getIdDoacao() {
		return idDoacao;
	}
	public void setIdDoacao(int idDoacao) {
		this.idDoacao = idDoacao;
	}
	public Doacao getDoacao() {
		return doacao;
	}
	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
	}
	public double getQtd() {
		return qtd;
	}
	public void setQtd(double qtd) {
		this.qtd = qtd;
	}
	
	

}
