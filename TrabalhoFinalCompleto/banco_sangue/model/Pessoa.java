package model;

import java.io.Serializable;

public class Pessoa implements Serializable, Comparable<Pessoa> {
	
	private static final long serialVersionUID = 1L;
	private int idPessoa;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String endereco;
	private String tipoSangue;
	private double qtdDoada = 0;
	private double totalDoacao = 0;
	private boolean doador = false;
	
	public double getTotalDoacao() {
		return totalDoacao;
	}

	public void setTotalDoacao(double totalDoacao) {
		this.totalDoacao += totalDoacao;
	}
	
	public Pessoa(String nome, String cpf, String telefone, String email, String endereco, String tipoSangue) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
		setEndereco(endereco);
		setTipoSangue(tipoSangue);
	}
	
	
	public Pessoa(int idPessoa, String nome, String cpf, String telefone, String email, String endereco, String tipoSangue) {
		setIdPessoa(idPessoa);
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
		setEndereco(endereco);
		setTipoSangue(tipoSangue);
	}
	
	public Pessoa() {

	}
	
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTipoSangue() {
		return tipoSangue;
	}
	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}
	
	public double getQtdDoada() {
		return qtdDoada;
	}

	public void setQtdDoada(double qtdDoada) {
		this.qtdDoada = qtdDoada;
	}

	public boolean getDoador() {
		return doador;
	}

	public void setDoador(boolean doador) {
		this.doador = doador;
	}

	@Override
	public int compareTo(Pessoa o) {
		if (this.getTotalDoacao() > o.getTotalDoacao()) {
            return -1;
        }
        if (this.getTotalDoacao() < o.getTotalDoacao()) {
            return 1;
        }
		return 0;
	}
	

}
