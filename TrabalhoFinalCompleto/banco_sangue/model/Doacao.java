package model;

import java.io.Serializable;

public class Doacao extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idDoacao;
	private Pessoa pessoa;
	private String DtDoacao;
	private double qntdDoada;
	
	public int getIdDoacao() {
		return idDoacao;
	}
	public void setIdDoacao(int idDoacao) {
		this.idDoacao = idDoacao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getDtDoacao() {
		return DtDoacao;
	}
	public void setDtDoacao(String dtDoacao) {
		DtDoacao = dtDoacao;
	}
	public double getQntdDoada() {
		return qntdDoada;
	}
	public void setQntdDoada(double qntdDoada) {
		this.qntdDoada = qntdDoada;
	}
	
	

}
