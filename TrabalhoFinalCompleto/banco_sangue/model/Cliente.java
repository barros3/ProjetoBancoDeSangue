package model;

import java.io.Serializable;

public class Cliente implements Serializable, Comparable<Cliente> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCliente;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String endereco;
	private double totalCompras;

	public double getTotalCompras() {
		return totalCompras;
	}

	public void setTotalCompras(double totalCompras) {
		this.totalCompras += totalCompras;
	}

	public Cliente(String nome, String cpf, String telefone, String email, String endereco) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
		setEndereco(endereco);
	}
	
	public Cliente(int idCliente, String nome, String cpf, String telefone, String email, String endereco) {
		setIdCliente(idCliente);
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
		setEndereco(endereco);
	}

	public Cliente() {

	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int compareTo(Cliente o) {
		if (this.getTotalCompras() > o.getTotalCompras()) {
            return -1;
        }
        if (this.getTotalCompras() < o.getTotalCompras()) {
            return 1;
        }
		return 0;
	}
}